package org.linlinjava.litemall.db.domain;

import java.util.Date;

public class UserParty {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_party.id
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_party.partyId
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    private Integer partyid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_party.partyName
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    private String partyname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_party.contrib
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    private Integer contrib;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_party.active
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    private Integer active;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_party.thisWeekActive
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    private Integer thisweekactive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_party.lastWeekActive
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    private Integer lastweekactive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_party.joinTime
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    private Date jointime;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_party
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public UserParty(Integer id, Integer partyid, String partyname, Integer contrib, Integer active, Integer thisweekactive, Integer lastweekactive, Date jointime) {
        this.id = id;
        this.partyid = partyid;
        this.partyname = partyname;
        this.contrib = contrib;
        this.active = active;
        this.thisweekactive = thisweekactive;
        this.lastweekactive = lastweekactive;
        this.jointime = jointime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_party
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public UserParty() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_party.id
     *
     * @return the value of user_party.id
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_party.id
     *
     * @param id the value for user_party.id
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_party.partyId
     *
     * @return the value of user_party.partyId
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public Integer getPartyid() {
        return partyid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_party.partyId
     *
     * @param partyid the value for user_party.partyId
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public void setPartyid(Integer partyid) {
        this.partyid = partyid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_party.partyName
     *
     * @return the value of user_party.partyName
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public String getPartyname() {
        return partyname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_party.partyName
     *
     * @param partyname the value for user_party.partyName
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public void setPartyname(String partyname) {
        this.partyname = partyname == null ? null : partyname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_party.contrib
     *
     * @return the value of user_party.contrib
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public Integer getContrib() {
        return contrib;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_party.contrib
     *
     * @param contrib the value for user_party.contrib
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public void setContrib(Integer contrib) {
        this.contrib = contrib;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_party.active
     *
     * @return the value of user_party.active
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public Integer getActive() {
        return active;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_party.active
     *
     * @param active the value for user_party.active
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public void setActive(Integer active) {
        this.active = active;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_party.thisWeekActive
     *
     * @return the value of user_party.thisWeekActive
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public Integer getThisweekactive() {
        return thisweekactive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_party.thisWeekActive
     *
     * @param thisweekactive the value for user_party.thisWeekActive
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public void setThisweekactive(Integer thisweekactive) {
        this.thisweekactive = thisweekactive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_party.lastWeekActive
     *
     * @return the value of user_party.lastWeekActive
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public Integer getLastweekactive() {
        return lastweekactive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_party.lastWeekActive
     *
     * @param lastweekactive the value for user_party.lastWeekActive
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public void setLastweekactive(Integer lastweekactive) {
        this.lastweekactive = lastweekactive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_party.joinTime
     *
     * @return the value of user_party.joinTime
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public Date getJointime() {
        return jointime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_party.joinTime
     *
     * @param jointime the value for user_party.joinTime
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public void setJointime(Date jointime) {
        this.jointime = jointime;
    }
}