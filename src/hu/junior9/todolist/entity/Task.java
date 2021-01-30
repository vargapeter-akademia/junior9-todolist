package hu.junior9.todolist.entity;

import java.time.LocalDateTime;

public class Task {
	private int id;
	private String summary;
	private LocalDateTime dueDate;
	private User user;
	private StateEnum state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public StateEnum getState() {
		return state;
	}

	public void setState(StateEnum state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Task(int id, String summary, LocalDateTime dueDate, User user, StateEnum state) {
		super();
		this.id = id;
		this.summary = summary;
		this.dueDate = dueDate;
		this.user = user;
		this.state = state;
	}

	public Task() {
	}
}
