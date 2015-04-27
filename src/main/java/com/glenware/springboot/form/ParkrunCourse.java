package com.glenware.springboot.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "PARKRUNCOURSE")
public class ParkrunCourse {
 
	@Id
	@Column(name = "PRCOURSE_ID")
	@GeneratedValue
	private Long courseId;
	
	@Column(name = "COURSENAME")
	@NotEmpty(message = "You must supply a courseName.")
	private String courseName;
	
	@Column(name = "URL")
	@NotEmpty(message = "You must supply a course url.")
	@URL(message = "Url must be of the format - http://glenware.wordpress.com")
	private String url;
	
	@Column(name = "AVERAGETIME")
	private Long averageTime;
	
	@Transient
	@NotEmpty(message = "You must supply a mm.")
	String mm;
	
	@Transient
	@NotEmpty(message = "You must supply a ss.")
	String ss;
	
	private String averageTimeString;
	
	private Long predictedTime;
	
	private String predictedTimeString;
	
	public ParkrunCourse() {
	}
	
	public ParkrunCourse(Long courseId, String courseName, String url, Long averageTime) {
		setCourseId(courseId);
		setCourseName(courseName);
		setUrl(url);
		setAverageTime(averageTime);
	}
	
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getAverageTime() {
		return averageTime;
	}

	public void setAverageTime(Long averageTime) {
		this.averageTime = averageTime;
	}

	public String getAverageTimeString() {
		if ( this.averageTimeString == null ) {
			averageTimeString = timeSecondsToHHMM(averageTime);
		}
		return averageTimeString;
	}
	
	public void setAverageTimeString(String averageTimeString) {
		this.averageTimeString = averageTimeString;
	}

	public Long getPredictedTime() {
		return predictedTime;
	}

	public void setPredictedTime(Long predictedTime) {
		this.predictedTime = predictedTime;
		this.predictedTimeString = timeSecondsToHHMM( predictedTime );
	}

	public String getPredictedTimeString() {
		return predictedTimeString;
	}

	public void setPredictedTimeString(String predictedTimeString) {
		this.predictedTimeString = predictedTimeString;
	}
	
	public String getMm() {
		return mm;
	}

	public void setMm(String mm) {
		this.mm = mm;
	}

	public String getSs() {
		return ss;
	}

	public void setSs(String ss) {
		this.ss = ss;
	}

	private static String timeSecondsToHHMM(Long seconds) {
		long timeMM = seconds / 60;
		long timeSS = seconds % 60;
		return  "" + timeMM + ":" + ( timeSS < 10 ? "0" + timeSS : timeSS );
	}
	
}