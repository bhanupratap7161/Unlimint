package com.pages;

public class Location
{
    private String country;

    private String city;

    private Street street;

    private String postcode;


    private String state;

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    public Street getStreet ()
    {
        return street;
    }

    public void setStreet (Street street)
    {
        this.street = street;
    }

    public String getPostcode ()
    {
        return postcode;
    }

    public void setPostcode (String postcode)
    {
        this.postcode = postcode;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }
}