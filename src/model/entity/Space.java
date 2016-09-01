package model.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by simon on 01/09/16.
 */
@Entity
@Table(
        name = "ANAG_IMPIANTI"
)
public class Space {

    @Id
    @Column(
            name = "ID_IMPIANTO",
            nullable = false
    )
    private Integer idImpianto;

    @Column(
            name = "DES_IMPIANTO",
            nullable = false
    )
    private String desImpianto;

    @Column(
            name = "IND_IMPIANTO"
    )
    private String addImpianto;

    @Column(
            name = "AMNT_STANZE"
    )
    private Integer roomNo;

    @Column(
            name = "AMNT_PORTE"
    )
    private Integer doorNo;

    @Column(
            name = "AMNT_FINESTRE"
    )
    private Integer windowsNo;

    @OneToMany(
            mappedBy = "space"
    )
    private List<Sdsi> schedaDipStrumImps;

    @OneToMany(
            mappedBy = "space"
    )
    private List<SpaceEmployee> spaceEmployees;

    public Integer getIdImpianto() {
        return idImpianto;
    }

    public void setIdImpianto(Integer idImpianto) {
        this.idImpianto = idImpianto;
    }

    public String getDesImpianto() {
        return desImpianto;
    }

    public void setDesImpianto(String desImpianto) {
        this.desImpianto = desImpianto;
    }

    public String getAddImpianto() {
        return addImpianto;
    }

    public void setAddImpianto(String addImpianto) {
        this.addImpianto = addImpianto;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public Integer getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(Integer doorNo) {
        this.doorNo = doorNo;
    }

    public Integer getWindowsNo() {
        return windowsNo;
    }

    public void setWindowsNo(Integer windowsNo) {
        this.windowsNo = windowsNo;
    }

    public List<Sdsi> getSchedaDipStrumImps() {
        return schedaDipStrumImps;
    }

    public void setSchedaDipStrumImps(List<Sdsi> schedaDipStrumImps) {
        this.schedaDipStrumImps = schedaDipStrumImps;
    }

    public List<SpaceEmployee> getSpaceEmployees() {
        return spaceEmployees;
    }

    public void setSpaceEmployees(List<SpaceEmployee> spaceEmployees) {
        this.spaceEmployees = spaceEmployees;
    }
}
