package assignment1.e1;

import java.util.Date;

public class GeometricObject {
	protected String color;
	protected boolean filled;
	protected Date dateCreated;
	
	public GeometricObject() {
		this("White", false, new Date());
	}
	
	public GeometricObject(String color, boolean filled, Date dateCreated){
		this.color = color;
		this.filled = filled;
		this.dateCreated = dateCreated;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
