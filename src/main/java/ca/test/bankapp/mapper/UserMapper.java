package ca.test.bankapp.mapper;

import ca.test.bankapp.dto.UserDTO;
import ca.test.bankapp.dto.UserRegisterDTO;
import ca.test.bankapp.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDTO(User user);
    UserRegisterDTO toUserRegisterDTO(User user);
    User toUser(UserDTO userDTO);
    User toUserRegisterDTO(UserRegisterDTO userRegisterDTO);

}
