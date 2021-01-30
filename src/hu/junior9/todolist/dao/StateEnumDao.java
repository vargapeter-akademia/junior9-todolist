package hu.junior9.todolist.dao;

import java.util.List;

import hu.junior9.todolist.entity.StateEnum;

public interface StateEnumDao {

	StateEnum findDefaultState();
	List<StateEnum> findAll();
	
}
