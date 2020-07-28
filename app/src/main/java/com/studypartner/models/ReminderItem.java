package com.studypartner.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ReminderItem implements Parcelable {
	private String time;
	private String date;
	private String title;
	private String description;
	private int notifyId;
	private boolean active;
	
	public ReminderItem() {}
	
	public ReminderItem(String title, String description, String time, String date) {
		this.title = title;
		this.description = description;
		this.time = time;
		this.date = date;
		this.active = true;
		createNotifyId();
	}
	
	protected ReminderItem(Parcel in) {
		title = in.readString();
		description = in.readString();
		date = in.readString();
		time = in.readString();
		notifyId = in.readInt();
		active = in.readInt() == 1;
	}
	
	public static final Creator<ReminderItem> CREATOR = new Creator<ReminderItem>() {
		@Override
		public ReminderItem createFromParcel(Parcel in) {
			return new ReminderItem(in);
		}
		
		@Override
		public ReminderItem[] newArray(int size) {
			return new ReminderItem[size];
		}
	};
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDate(String setdate) {
		date = setdate;
	}
	
	public void setDescription(String setDes) {
		description = setDes;
	}
	
	public void setTime(String setTime) {
		time = setTime;
	}
	
	public void edit (String editTitle, String editDescription, String editTime, String editDate) {
		this.title = editTitle;
		this.description = editDescription;
		this.date = editDate;
		this.time = editTime;
		createNotifyId();
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getNotifyId() {
		return notifyId;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public void createNotifyId() {
		String dn = "0";
		String mdate = date.substring(0, 2) + date.substring(3, 5);
		if (time.substring(6).equals("PM"))
			dn = "1";
		String mtime = time.substring(0, 2) + time.substring(3, 5) + dn;
		notifyId = Integer.parseInt(mdate + mtime);
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(title);
		parcel.writeString(description);
		parcel.writeString(date);
		parcel.writeString(time);
		parcel.writeInt(notifyId);
		parcel.writeInt(active ? 1 : 0);
	}
	
	@Override
	public String toString() {
		return "ReminderItem{" +
				"title='" + title + '\'' +
				", description='" + description + '\'' +
				", date='" + date + '\'' +
				", time='" + time + '\'' +
				", notifyId=" + notifyId +
				", active=" + active +
				'}';
	}
}