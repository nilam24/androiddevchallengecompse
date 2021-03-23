package com.example.androiddevchallenge

data class WeatherDataModel(var location:String,var image:Int,var contentDes:String,var date:String,var minTemp:String,var maxTemp:String) {

    companion object {
        fun setWeatherData(): MutableList<WeatherDataModel> {
            val list: MutableList<WeatherDataModel> = mutableListOf()

            val weatherDataModel1 = WeatherDataModel("India",R.drawable.ic_light_rain,"Spring light rain","Monday","13","25")
            val weatherDataModel2 = WeatherDataModel("India",R.drawable.ic_clear,"Spring clear","Tuesday","14","26")
            val weatherDataModel3 = WeatherDataModel("India",R.drawable.ic_light_clouds,"Spring light clouds","Wednesday","11","27")
            val weatherDataModel4 = WeatherDataModel("India",R.drawable.ic_fog,"Spring fog","Thursday","12","28")
            val weatherDataModel5 = WeatherDataModel("India",R.drawable.ic_snow,"Spring snow","Friday","10","18")
            val weatherDataModel6 = WeatherDataModel("India",R.drawable.ic_clear,"Spring clear","Saturday","15","27")
            val weatherDataModel7 = WeatherDataModel("India",R.drawable.ic_light_clouds,"Spring light clouds","Sunday","16","26")

            val weatherDataModel8 = WeatherDataModel("India",R.drawable.ic_clear,"Summer clear","Monday","20","45")
            val weatherDataModel9 = WeatherDataModel("India",R.drawable.ic_clear,"Summer clear","Tuesday","20","45")
            val weatherDataModel10 = WeatherDataModel("India",R.drawable.ic_clear,"Summer clear","Wednesday","20","45")
            val weatherDataModel11 = WeatherDataModel("India",R.drawable.ic_storm,"Summer storm","Thursday","20","45")
            val weatherDataModel12 = WeatherDataModel("India",R.drawable.ic_storm,"Summer storm","Friday","20","45")
            val weatherDataModel13= WeatherDataModel("India",R.drawable.ic_clear,"Summer clear","Saturday","20","45")
            val weatherDataModel14 = WeatherDataModel("India",R.drawable.ic_clear,"Summer clear","Sunday","20","45")

            val weatherDataModel15 = WeatherDataModel("India",R.drawable.ic_storm,"Rainy storm","Monday","13","27")
            val weatherDataModel16 = WeatherDataModel("India",R.drawable.ic_rain,"Rainy rain","Tuesday","17","28")
            val weatherDataModel17 = WeatherDataModel("India",R.drawable.ic_light_rain,"Rainy light rain","Wednesday","15","35")
            val weatherDataModel18 = WeatherDataModel("India",R.drawable.ic_clear,"Rainy clear","Thursday","19","30")
            val weatherDataModel19 = WeatherDataModel("India",R.drawable.ic_rain,"Rainy rain","Friday","20","25")
            val weatherDataModel20 = WeatherDataModel("India",R.drawable.ic_rain,"Rainy rain","Saturday","15","18")
            val weatherDataModel21 = WeatherDataModel("India",R.drawable.ic_rain,"Rainy rain","Sunday","16","17")

            val weatherDataModel22 = WeatherDataModel("India",R.drawable.ic_fog,"Winter fog","Monday","13","17")
            val weatherDataModel23 = WeatherDataModel("India",R.drawable.ic_fog,"Winter fog","Tuesday","14","18")
            val weatherDataModel24 = WeatherDataModel("India",R.drawable.ic_storm,"Winter storm","Wednesday","11","15")
            val weatherDataModel25 = WeatherDataModel("India",R.drawable.ic_light_rain,"Winter light rain","Thursday","12","12")
            val weatherDataModel26 = WeatherDataModel("India",R.drawable.ic_snow,"Winter snow","Friday","12","10")
            val weatherDataModel27 = WeatherDataModel("India",R.drawable.ic_snow,"Winter snow","Saturday","15","8")
            val weatherDataModel28 = WeatherDataModel("India",R.drawable.ic_snow,"Winter snow","Sunday","16","1")

            list.add(weatherDataModel1)
            list.add(weatherDataModel2)
            list.add(weatherDataModel3)
            list.add(weatherDataModel4)
            list.add(weatherDataModel5)
            list.add(weatherDataModel6)
            list.add(weatherDataModel7)
            list.add(weatherDataModel8)
            list.add(weatherDataModel9)
            list.add(weatherDataModel10)
            list.add(weatherDataModel11)
            list.add(weatherDataModel12)
            list.add(weatherDataModel13)
            list.add(weatherDataModel14)
            list.add(weatherDataModel15)
            list.add(weatherDataModel16)
            list.add(weatherDataModel17)
            list.add(weatherDataModel18)
            list.add(weatherDataModel19)
            list.add(weatherDataModel20)
            list.add(weatherDataModel21)
            list.add(weatherDataModel22)
            list.add(weatherDataModel23)
            list.add(weatherDataModel24)
            list.add(weatherDataModel25)
            list.add(weatherDataModel26)
            list.add(weatherDataModel27)
            list.add(weatherDataModel28)

            return list
        }
    }

}

