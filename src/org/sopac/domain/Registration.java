package org.sopac.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sachin
 * Date: 5/20/12
 * Time: 5:39 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table
public class Registration {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    Long id;
    private String title;
    private String firstName;
    private String surname;
    private String email;
    private String country;
    private String jobTitle;


    private String mailingAddress;
    private String telephone;
    private String fax;
    private String nationality;
    private String passportNo;
    private Date dateOfIssue;
    private String placeOfIssue;
    private Date expiryDate;
    private String specialMealsRequired;
    private String organisationName;
    //private String organisationTypes;  //separated by comma delimiters

    private String accomodationFirstChoice;
    //private String accomodationSecondChoice;
    //private String accomodationThirdChoice;

    //private boolean displayTable;
    //private boolean posters;
    //private boolean displayBoard;
    //private boolean brochures;
    //private boolean other;
    //private String otherMaterials;

    private Date dateRegistered;

    //public Integer tripFirstPreference;
    //public Integer tripSecondPreference;


    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getSpecialMealsRequired() {
        return specialMealsRequired;
    }

    public void setSpecialMealsRequired(String specialMealsRequired) {
        this.specialMealsRequired = specialMealsRequired;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }


    public String getAccomodationFirstChoice() {
        return accomodationFirstChoice;
    }

    public void setAccomodationFirstChoice(String accomodationFirstChoice) {
        this.accomodationFirstChoice = accomodationFirstChoice;
    }


}
