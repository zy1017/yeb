package com.xxx.server.service.Impl;

import com.xxx.server.pojo.MailLog;
import com.xxx.server.mapper.MailLogMapper;
import com.xxx.server.service.IMailLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zy
 * @since 2022-07-29
 */
@Service
public class MailLogServiceImpl extends ServiceImpl<MailLogMapper, MailLog> implements IMailLogService {

}
