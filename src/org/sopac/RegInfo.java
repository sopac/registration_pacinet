package org.sopac;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sachin
 * Date: 5/20/12
 * Time: 4:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegInfo implements Serializable {

    private String title;
    private String firstName;
    private String surname;
    private String email;
    private String jobTitle;
    private String country;
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
    private List<String> organisationTypes;

    private String accomodationFirstChoice;
    private String accomodationSecondChoice;
    private String accomodationThirdChoice;

    private boolean displayTable;
    private boolean posters;
    private boolean displayBoard;

    private boolean brochures;
    private boolean other;
    private String otherMaterials;

    public Integer tripFirstPreference;
    public Integer tripSecondPreference;

    public Integer getTripFirstPreference() {
        return tripFirstPreference;
    }

    public void setTripFirstPreference(Integer tripFirstPreference) {
        this.tripFirstPreference = tripFirstPreference;
    }

    public Integer getTripSecondPreference() {
        return tripSecondPreference;
    }

    public void setTripSecondPreference(Integer tripSecondPreference) {
        this.tripSecondPreference = tripSecondPreference;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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

    public List<String> getOrganisationTypes() {
        return organisationTypes;
    }

    public void setOrganisationTypes(List<String> organisationTypes) {
        this.organisationTypes = organisationTypes;
    }

    public String getAccomodationFirstChoice() {
        return accomodationFirstChoice;
    }

    public void setAccomodationFirstChoice(String accomodationFirstChoice) {
        this.accomodationFirstChoice = accomodationFirstChoice;
    }

    public String getAccomodationSecondChoice() {
        return accomodationSecondChoice;
    }

    public void setAccomodationSecondChoice(String accomodationSecondChoice) {
        this.accomodationSecondChoice = accomodationSecondChoice;
    }

    public String getAccomodationThirdChoice() {
        return accomodationThirdChoice;
    }

    public void setAccomodationThirdChoice(String accomodationThirdChoice) {
        this.accomodationThirdChoice = accomodationThirdChoice;
    }

    public boolean isDisplayTable() {
        return displayTable;
    }

    public void setDisplayTable(boolean displayTable) {
        this.displayTable = displayTable;
    }

    public boolean isPosters() {
        return posters;
    }

    public void setPosters(boolean posters) {
        this.posters = posters;
    }

    public boolean isDisplayBoard() {
        return displayBoard;
    }

    public void setDisplayBoard(boolean displayBoard) {
        this.displayBoard = displayBoard;
    }

    public boolean isBrochures() {
        return brochures;
    }

    public void setBrochures(boolean brochures) {
        this.brochures = brochures;
    }

    public boolean isOther() {
        return other;
    }

    public void setOther(boolean other) {
        this.other = other;
    }

    public String getOtherMaterials() {
        return otherMaterials;
    }

    public void setOtherMaterials(String otherMaterials) {
        this.otherMaterials = otherMaterials;
    }


}
