package problem2;

class Person {
	private String lastName;
	private String firstName;
	private int age;

	// --------------------------------------------------------------
	public Person(String last, String first, int age) { // constructor
		this.lastName = last;
		this.firstName = first;
		this.age = age;
	}
	

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;		
		result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
		result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
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
		Person other = (Person) obj;
		
		
		
		return this.lastName.equals(other.lastName) &&  this.firstName.equals(other.firstName) ;
	}


	// --------------------------------------------------------------
	public String getLast() // get last name
	{
		return lastName;
	}

	@Override
	public String toString() {
		return "Person <lastName=" + lastName + " FirstName=" + firstName + "Age=" + age + ">";
	}
}