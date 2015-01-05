package world.analytics

import java.sql.ResultSet
import world.model.Country
import play.api.db.DB
import play.api.Play.current

object CountryAnalytics {
	def populationDensity(countries : List[Country]): List[(String, Double)] = {
		countries.map(country => (
			country.name, (country.population / country.surfaceArea))
		)      
	}
}
  
/*  
def languagePopulation(country : String): List[(String, Double)] = {
	var conn = DB.getConnection("default")
  val resultSet = conn.createStatement.executeQuery(s"SELECT L.Language, L.Percentage," + 
      "ROUND((C.Population * (L.Percentage / 100)), 0) AS 'Language Population'" + 
      "FROM Country AS C JOIN CountryLanguage AS L ON C.CountryCode = L.CountryCode WHERE C.Name = '$country'"
  ) 
}  
**/

