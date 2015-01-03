package world.analytics

import world.model.Country

object CountryAnalytics {
	def populationDensity(countries : List[Country]): List[(String, Double)] = {
		countries.map(country => (
			country.name, (country.population / country.surfaceArea))
		)      
	}
}