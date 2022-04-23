package com.example.myapplication

class User ()
{
    var fname=""
    var lname=""
    var uname=""
    constructor(fname:String,lname:String):this()
    {
        this.fname=fname
        this.lname=lname
    }
    constructor(fname:String,lname:String,uname:String):this(fname,lname)
    {
        this.uname=uname
    }
}