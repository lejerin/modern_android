package com.example.archsample.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

// Serializable 의 한 분류인 Parcelable
public class Post implements Parcelable {

    private long userId;
    private long id;
    private String title;
    private String body;

    public Post(long userId, long id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public long getUserId() {
        return userId;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }


    //Parcelable은 Interface입니다. 그래서 implements를 통하여 내부 메소드들을 구현해야 합니다.
    @Override
    public int describeContents() {
        return 0;
    }


    /*
    writeToParcel은 객체가 직렬화되어 보내지기 이전에 데이터를 직렬화시켜주는 메소드로,
    dest에 순차적으로 Class 내부에 있는 데이터들을 저장시켜놓습니다.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.userId);
        dest.writeLong(this.id);
        dest.writeString(this.title);
        dest.writeString(this.body);
    }

    //객체를 받았을 때 직렬화를 풀어주는 로직
    protected Post(Parcel in){
        this.userId = in.readLong();
        this.id = in.readLong();
        this.title = in.readString();
        this.body = in.readString();
    }

    /*
    Creator가 없다면 데이터를 넘기게 되더라고 Creator가 없다는 Exception을 뿌려주기 때문에
    필히 작성을 해줘야 하는 부분
     */
    public static final Parcelable.Creator<Post> CREATOR = new Parcelable.Creator<Post>(){

        @Override
        public Post createFromParcel(Parcel source) {
            return new Post(source);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[0];
        }
    };
}
