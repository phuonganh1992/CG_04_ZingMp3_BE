package com.zingmp3.service.role;

import com.zingmp3.model.Role;
import com.zingmp3.service.IGeneralService;

import java.util.Optional;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
