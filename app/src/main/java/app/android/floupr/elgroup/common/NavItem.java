package app.android.floupr.elgroup.common;

/**
 * Created by VIKRAM SINGH on 16-Feb-17.
 */

public class NavItem {

    public String getTitle() {
        return title;
    }
    public NavItem(String title, int id){
        this.title = title;
        this.picId = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    private int picId;
}
