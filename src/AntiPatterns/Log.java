package AntiPatterns;

public class Log {
    String phoneNumber;
    String callDate;
    String callType;
    String callDuration;
    String note;
    String name;
    String email;

    public Log(String phoneNumber, String callDate, String callType, String callDuration, String note, String name, String email) {
        this.phoneNumber = phoneNumber;
        this.callDate = callDate;
        this.callType = callType;
        this.callDuration = callDuration;
        this.note = note;
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCallDate() {
        return callDate;
    }

    public void setCallDate(String callDate) {
        this.callDate = callDate;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(String callDuration) {
        this.callDuration = callDuration;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Log() {
    }


}
