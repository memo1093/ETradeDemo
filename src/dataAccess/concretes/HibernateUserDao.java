package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao{

	private List<User> users= new ArrayList<User>();
	
	

	@Override
	public void add(User user) {
		users.add(user);
				
	}

	@Override
	public void update(User user) {
		users.set(user.getId(), user);
		
	}

	@Override
	public void delete(User user) {
		users.remove(user);
		
	}

	@Override
	public User get(int id) {
		
		for (User user : users) {
			if (user.getId()==id) {
				return user;
			}
		}
		
		return null;
	}

	@Override
	public List<User> getAll() {
		
		return users;
	}
	
	
}
