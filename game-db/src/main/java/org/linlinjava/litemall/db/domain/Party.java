package org.linlinjava.litemall.db.domain;

public class Party {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column party.id
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column party.name
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column party.announce
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    private String announce;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column party.level
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    private Integer level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column party.construction
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    private Integer construction;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column party.creator
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    private String creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column party.member
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    private String member;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column party.request_join
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    private String requestJoin;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table party
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public Party(Integer id, String name, String announce, Integer level, Integer construction, String creator, String member, String requestJoin) {
        this.id = id;
        this.name = name;
        this.announce = announce;
        this.level = level;
        this.construction = construction;
        this.creator = creator;
        this.member = member;
        this.requestJoin = requestJoin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table party
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public Party() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column party.id
     *
     * @return the value of party.id
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column party.id
     *
     * @param id the value for party.id
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column party.name
     *
     * @return the value of party.name
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column party.name
     *
     * @param name the value for party.name
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column party.announce
     *
     * @return the value of party.announce
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public String getAnnounce() {
        return announce;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column party.announce
     *
     * @param announce the value for party.announce
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public void setAnnounce(String announce) {
        this.announce = announce == null ? null : announce.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column party.level
     *
     * @return the value of party.level
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column party.level
     *
     * @param level the value for party.level
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column party.construction
     *
     * @return the value of party.construction
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public Integer getConstruction() {
        return construction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column party.construction
     *
     * @param construction the value for party.construction
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public void setConstruction(Integer construction) {
        this.construction = construction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column party.creator
     *
     * @return the value of party.creator
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column party.creator
     *
     * @param creator the value for party.creator
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column party.member
     *
     * @return the value of party.member
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public String getMember() {
        return member;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column party.member
     *
     * @param member the value for party.member
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public void setMember(String member) {
        this.member = member == null ? null : member.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column party.request_join
     *
     * @return the value of party.request_join
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public String getRequestJoin() {
        return requestJoin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column party.request_join
     *
     * @param requestJoin the value for party.request_join
     *
     * @mbg.generated Thu Jan 09 22:55:27 CST 2020
     */
    public void setRequestJoin(String requestJoin) {
        this.requestJoin = requestJoin == null ? null : requestJoin.trim();
    }
}