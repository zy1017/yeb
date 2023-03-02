package com.xxx.server.task;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xxx.server.constants.MailConstants;
import com.xxx.server.pojo.Employee;
import com.xxx.server.pojo.MailLog;
import com.xxx.server.service.IEmployeeService;
import com.xxx.server.service.IMailLogService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @BelongsProject: yeb
 * @BelongsPackage: com.xxx.server.task
 * @Author: zuoyu
 * @CreateTime: 2023-03-02  19:28
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public class MailTask {
    @Autowired
    private IMailLogService mailLogService;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private IEmployeeService employeeService;

    // 定时任务 1O秒执行一次
    @Scheduled(cron = "0/10 * * * * ?")
    public void mailTask() {
        List<MailLog> list = mailLogService.list(new QueryWrapper<MailLog>().eq("status", 0).lt("tryTime",
                LocalDateTime.now()));
        list.forEach(mailLog -> {
            // 如果重试次数超过三次,更新状态为投递失败,不在重试
            if (3 <= mailLog.getCount()) {
                mailLogService.update(new UpdateWrapper<MailLog>().set("status", 2).eq("msgId", mailLog.
                        getMsgId()));
            }
            mailLogService.update(new UpdateWrapper<MailLog>().set("count", mailLog.getCount() + 1)
                    .set("updateTime", LocalDateTime.now()).set("tryTime", LocalDateTime.now().
                            plusMinutes(MailConstants.MSG_TIMEOUT)).eq("msgId", mailLog.getMsgId()));
            Employee emp = employeeService.getEmployee(mailLog.getEid()).get(0);
            rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME, MailConstants.MAIL_ROUTING_KEY_NAME,
                    emp, new CorrelationData(mailLog.getMsgId()));
        });
    }
}
