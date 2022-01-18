package com.example.sampleproject

object Details {
    private var name: String = ""
    private var email: String = ""
    private var phone:String = ""
    private var designation: String = ""
    private var department: String = ""
    private var eventType: String = ""
    private var degree: String = ""
    private var yearOfStudy: String = ""
    private var date: String = ""
    private var time: String = ""

    fun setName(name:String){
        this.name = name
    }
    fun setEmail(email:String){
        this.email= email
    }
    fun setPhone(phone:String){
        this.phone = phone
    }
    fun setDesignation(designation:String){
        this.designation = designation
    }
    fun setDepartment(department:String){
        this.department = department
    }
    fun setEventType(eventType:String){
        this.eventType = eventType
    }
    fun setDegree(degree:String){
        this.degree = degree
    }
    fun setYearOfStudy(yearOfStudy:String){
        this.yearOfStudy = yearOfStudy
    }
    fun setDate(date:String){
        this.date = date
    }
    fun setTime(time:String){
        this.time = time
    }

    fun getDetails(): String{
        var eventDetails: String
        eventDetails= "Name:"+ name +"\nEmail:"+ email +"\nPhone:"+ phone + "\nDesignation:"+ designation + "\nDepartment:"+ department + "\nEvent:"+ eventType + "\nDegree:"+ degree + "\nYear of study:"+ yearOfStudy + "\nDate:"+ date + "\nTime:"+ time
        return eventDetails
    }
    /*fun clear(){
        eventDetails = " "
    }*/
}