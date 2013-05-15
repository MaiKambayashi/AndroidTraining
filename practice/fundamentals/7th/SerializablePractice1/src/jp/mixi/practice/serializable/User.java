package jp.mixi.practice.serializable;

import java.io.Serializable;
import java.util.Date;
import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String name;
    private int id;
    private int age;
    private String keyword;
    private Status status;
    
    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public static class Status implements Parcelable, Serializable{
        private Date mPostedDate;
        private String mText;
		public Date getPostedDate() {
            return mPostedDate;
        }
        public String getText(){
            return mText;
        }
        public void setPostedDate(Date date){
            mPostedDate = date;
        }
        public void setText(String text) {
            mText = text;
        }
        
    	@Override
    	public int describeContents() {
    		return 0;
    	}

    	@Override
    	public void writeToParcel(Parcel out, int flags) {
            out.writeString(mText);
        }

        public static final Parcelable.Creator<Status> CREATOR = new Parcelable.Creator<Status>() {
            public Status createFromParcel(Parcel in) {
                return new Status(in);
            }

            public Status[] newArray(int size) {
                return new Status[size];
            }
        };

        public Status() {}

        private Status(Parcel in) {
            mText = in.readString();
        }
    }

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
        out.writeInt(id);
        out.writeInt(age);
        out.writeString(name);
        out.writeString(keyword);
        out.writeSerializable((Status) status);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User() {}

    private User(Parcel in) {
        id = in.readInt();
        age = in.readInt();
        name = in.readString();
        keyword = in.readString();
        status = (Status) in.readSerializable();
    }

}
