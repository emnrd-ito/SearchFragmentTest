package testdemo.com.searchfragmenttest.model;


import android.os.Parcel;
import android.os.Parcelable;


// This Parcelable class generated by:
// https://github.com/mcharmas/android-parcelable-intellij-plugin
//
public class EmployeeDataParcelable implements Parcelable {

    private Integer eMNRDPassID;
    private String name;
    private String cell;
    private String title;
    private String emailAddress;
    private String division;
    private String location;
    private String phone;
    private String fax;
    private String address;
    private String city;
    private String state;
    private String zip;
    private Double latitude;
    private Double longitude;

    public Integer geteMNRDPassID() {
        return eMNRDPassID;
    }

    public String getName() {
        return name;
    }

    public String getCell() {
        return cell;
    }

    public String getTitle() {
        return title;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getDivision() {
        return division;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.eMNRDPassID);
        dest.writeString(this.name);
        dest.writeString(this.cell);
        dest.writeString(this.title);
        dest.writeString(this.emailAddress);
        dest.writeString(this.division);
        dest.writeString(this.location);
        dest.writeString(this.phone);
        dest.writeString(this.fax);
        dest.writeString(this.address);
        dest.writeString(this.city);
        dest.writeString(this.state);
        dest.writeString(this.zip);
        dest.writeValue(this.latitude);
        dest.writeValue(this.longitude);
    }

    public EmployeeDataParcelable() {
    }

    // This constructor was written manually
    public EmployeeDataParcelable(EmployeeGeneratedData employeeGeneratedData) {
        this.eMNRDPassID = employeeGeneratedData.getEMNRDPassID();
        this.name = employeeGeneratedData.getName();
        this.cell = employeeGeneratedData.getCell();
        this.title = employeeGeneratedData.getTitle();
        this.emailAddress = employeeGeneratedData.getEmailAddress();
        this.division = employeeGeneratedData.getDivision();
        this.location = employeeGeneratedData.getLocation();
        this.phone = employeeGeneratedData.getPhone();
        this.fax = employeeGeneratedData.getFax();
        this.address = employeeGeneratedData.getAddress();
        this.city = employeeGeneratedData.getCity();
        this.state = employeeGeneratedData.getState();
        this.zip = employeeGeneratedData.getZip();
        this.latitude = employeeGeneratedData.getLatitude();
        this.longitude = employeeGeneratedData.getLongitude();

    }

    protected EmployeeDataParcelable(Parcel in) {
        this.eMNRDPassID = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.cell = in.readString();
        this.title = in.readString();
        this.emailAddress = in.readString();
        this.division = in.readString();
        this.location = in.readString();
        this.phone = in.readString();
        this.fax = in.readString();
        this.address = in.readString();
        this.city = in.readString();
        this.state = in.readString();
        this.zip = in.readString();
        this.latitude = (Double) in.readValue(Double.class.getClassLoader());
        this.longitude = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<EmployeeDataParcelable> CREATOR = new Parcelable.Creator<EmployeeDataParcelable>() {
        @Override
        public EmployeeDataParcelable createFromParcel(Parcel source) {
            return new EmployeeDataParcelable(source);
        }

        @Override
        public EmployeeDataParcelable[] newArray(int size) {
            return new EmployeeDataParcelable[size];
        }
    };

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCell(String cell) {
        this.cell = cell;
    } // TODO VOIP something
}
