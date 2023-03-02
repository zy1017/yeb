package com.xxx.server.service.Impl;

import com.xxx.server.pojo.Nation;
import com.xxx.server.mapper.NationMapper;
import com.xxx.server.service.INationService;
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
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

}
