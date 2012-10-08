package org.sopac;

import org.hibernate.Session;
import org.primefaces.event.FlowEvent;
import org.sopac.domain.Registration;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: sachin
 * Date: 5/20/12
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "reg")
@ViewScoped
public class RegBean {

    private String exEmail;

    public String getExEmail() {
        return exEmail;
    }

    public void setExEmail(String exEmail) {
        this.exEmail = exEmail;
    }

    public RegInfo getInfo() {
        return info;
    }

    public void setInfo(RegInfo info) {
        this.info = info;
    }

    RegInfo info = new RegInfo();

    private static Logger logger = Logger.getLogger(RegBean.class.getName());

    public String onFlowProcess(FlowEvent event) {


        logger.info("Current wizard step:" + event.getOldStep());
        logger.info("Next step:" + event.getNewStep());
        return event.getNewStep();
    }

    public void load(ActionEvent actionEvent) {
        System.out.println("Loading..");
        if (!getExEmail().contains("@") || !getExEmail().contains(".")) {
            System.out.println(getExEmail() + " ...");
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Email Provided", "Please go back and enter a correct email address.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return;
        }
    }

    public void save(ActionEvent actionEvent) {
        //Persist user
        //FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getFirstname());
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        //System.out.println(info.getFirstName());
        //System.out.println(info.getEmail());

        if (!info.getEmail().contains("@") || !info.getEmail().contains(".")) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Email Provided", "Please go back and enter a correct email address.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return;
        }


        try {
            //save
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Registration r = new Registration();
            r.setTitle(info.getTitle());
            r.setAccomodationFirstChoice(info.getAccomodationFirstChoice());
            //r.setAccomodationSecondChoice(info.getAccomodationSecondChoice());
            //r.setAccomodationThirdChoice(info.getAccomodationThirdChoice());
            //r.setBrochures(info.isBrochures());
            r.setCountry(info.getCountry());
            r.setDateOfIssue(info.getDateOfIssue());
            r.setJobTitle(info.getJobTitle());
            //r.setDisplayBoard(info.isDisplayBoard());
            //r.setDisplayTable(info.isDisplayTable());
            r.setEmail(info.getEmail());
            r.setExpiryDate(info.getExpiryDate());
            r.setFax(info.getFax());
            r.setMailingAddress(info.getMailingAddress());
            r.setFirstName(info.getFirstName());
            r.setSurname(info.getSurname());
            r.setNationality(info.getNationality());
            r.setOrganisationName(info.getOrganisationName());
            String orgTypes = "";
            //for (String tmp : info.getOrganisationTypes()) orgTypes = orgTypes + tmp + ", ";
            //r.setOrganisationTypes(orgTypes);
            //r.setOther(info.isOther());
            //r.setOtherMaterials(info.getOtherMaterials());
            r.setPassportNo(info.getPassportNo());
            r.setPlaceOfIssue(info.getPlaceOfIssue());
            //r.setPosters(info.isPosters());
            r.setSpecialMealsRequired(info.getSpecialMealsRequired());
            r.setTelephone(info.getTelephone());
            //r.setTripFirstPreference(info.getTripFirstPreference());
            //r.setTripSecondPreference(info.getTripSecondPreference());

            r.setDateRegistered(new Date());

            s.save(r);
            s.getTransaction().commit();
            s.close();
            System.out.println("Registration Saved.");

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration Complete", "Thank you for registering for the 2012 PacINET PICISOC Conference.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception ex) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registration Failed", "Please contact <a href='mailto:sachindra@sopac.org'>sachindra@sopac.org</a> to report this issue.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }


    }


}
