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

