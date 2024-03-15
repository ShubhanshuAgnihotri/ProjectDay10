package com.devdroid.projectday10;

public class Model {
    private  String name;
    private Boolean selected;// name of the employee
  //  private  String id; // id of the employee
   // private  String designation; // designation of the employee
    //private  String phone; // phone o
    public Model(String name) {
        this.name = name;
        //this.id = id;
       // this.designation = designation;
       // this.phone = phone;
    }

  /*  public Model(String name, Boolean selected) {
        this.name = name;
        this.selected = selected;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
    // public String getId() {
        //return id;
   // }

   // public void setId(String id) {
       // this.id = id;
   // }

   // public String getDesignation() {
        //return designation;
    //}

   // public void setDesignation(String designation) {
      //  this.designation = designation;
    //}

   // public String getPhone() {
     //   return phone;
    //}

    //public void setPhone(String phone) {
      //  this.phone = phone;
    //}
}
