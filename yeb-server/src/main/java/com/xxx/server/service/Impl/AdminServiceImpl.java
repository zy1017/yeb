package com.xxx.server.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.server.config.security.component.JwtTokenUtil;
import com.xxx.server.pojo.Admin;
import com.xxx.server.mapper.AdminMapper;
import com.xxx.server.pojo.ResponseBean;
import com.xxx.server.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.server.utils.AdminUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zy
 * @since 2022-07-29
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    public JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public ResponseBean login(String username, String password, String code, HttpServletRequest request) {
        // 获取验证码
        String captcha = (String) request.getSession().getAttribute("captcha");
        // 忽略大小写 校验验证码是否正确
        if (StringUtils.isEmpty(captcha) || !captcha.equalsIgnoreCase(code)) {
            return ResponseBean.error("验证码输入错误，请重新输入！");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = bcryptPasswordEncoder.encode(userDetails.getPassword());
        if (userDetails == null || passwordEncoder.matches(password, userDetails.getPassword())) {
            return ResponseBean.error("用户名或者密码不正确");
        }
        if (!userDetails.isEnabled()) {
            return ResponseBean.error("账号被禁用，请联系管理员！！");
        }
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return ResponseBean.success("登录成功", tokenMap);
    }

    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    @Override
    public Admin getAdminByUserName(String username) {
        //使用MybatisPlus的单个查询方法，selectOne 用.eq 比较方法在匹配查询条件  用户名和用户状态（是否异常）
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("username", username)
                .eq("enabled", true));
    }

    @Override
    public List<Admin> getAllAdmins(String keywords) {
        //return adminMapper.getAllAdmins(AdminUtils.getCurrentAdmin().getId(),keywords);
        return adminMapper.getAllAdmins(1,keywords);
    }
}
