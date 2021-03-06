package hu.junior9.todolist.entity;

public class StateEnum {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		StateEnum other = (StateEnum) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public StateEnum(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public StateEnum() {
		super();
	}

}
