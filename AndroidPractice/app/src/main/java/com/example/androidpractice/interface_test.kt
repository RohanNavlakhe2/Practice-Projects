package com.example.androidpractice

interface TaxRegime{
    val a:String
}

class NewTaxRegime(override val a: String) :TaxRegime{

}