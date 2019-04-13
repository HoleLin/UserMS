package pojo;

import entity.User;

import java.util.List;

/**
 * InterfaceName: UserMapper
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/4/9
 */
public interface UserMapper {

	User checkUsername(String username);

	List<User> findAll();

	void insertUser(User user);

	void update(User user);

	void delete(String username);
}
