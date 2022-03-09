package com.example.sampleproject

object Details {
    private var id: String?= null
    private var name: String?= null
    private var email: String ?= null
    private var phone:String ?= null
    private var designation: String ?= null
    private var department: String ?= null
    private var eventType: String ?= null
    private var degree: String ?= null
    private var yearOfStudy: String ?= null
    private var date: String ?= null
    private var startTime: String ?=null
    private var endTime: String ?=null

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
    fun setStartTime(startTime:String){
        this.startTime = startTime
    }
    fun setEndTime(endTime:String){
        this.endTime = endTime
    }
    fun setId(id:String){
        this.id = id
    }

//    fun getDetails(): String{
//        var eventDetails: String
//        eventDetails= "Name:"+ name +"\nEmail:"+ email +"\nPhone:"+ phone + "\nDesignation:"+ designation + "\nDepartment:"+ department + "\nEvent:"+ eventType + "\nDegree:"+ degree + "\nYear of study:"+ yearOfStudy + "\nDate:"+ date + "\nTime:"+ time
//        return eventDetails
//    }
    /*fun clear(){
        eventDetails = " "
    }*/
    fun getName(): String? {
        return this.name
    }
    fun getEmail(): String?{
        return this.email
    }
    fun getPhone(): String?{
        return this.phone
    }
    fun getDesignation(): String?{
        return this.designation
    }
    fun getDepartment(): String?{
        return this.department
    }
    fun getEventType(): String?{
        return this.eventType
    }
    fun getDegree(): String?{
        return this.degree
    }
    fun getYearOfStudy(): String?{
        return this.yearOfStudy
    }
    fun getDate(): String?{
        return this.date
    }
    fun getStartTime(): String?{
        return this.startTime
    }
    fun getEndTime(): String?{
        return this.endTime
    }
    fun getId():String?{
        return this.id
    }
}