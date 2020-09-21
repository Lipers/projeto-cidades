package com.example.felipesouza.resources;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.felipesouza.domain.City;
import com.example.felipesouza.domain.State;
import com.example.felipesouza.dto.StateDTO;
import com.example.felipesouza.services.exception.ObjectNotFoundException;

@RestController
@RequestMapping(value="/cities")
public class CityResource {

	/* 1 */
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<City>> findAll() throws FileNotFoundException {

		File arquivo = new File("dados.csv");

		Scanner leitor = new Scanner(arquivo);
		List<City> cities = new ArrayList<>();

		leitor.nextLine();

		while(leitor.hasNext()) {

			String[] campos = leitor.nextLine().split(",");
			City cidade = new City(Integer.parseInt(campos[0]), campos[1], campos[2], Boolean.parseBoolean(campos[3]), Double.parseDouble(campos[4]), Double.parseDouble(campos[5]), campos[6], campos[7], campos[8], campos[9]);

			cities.add(cidade);


		}

		leitor.close();

		return ResponseEntity.ok().body(cities);
	}



	/* 2 */
	@RequestMapping(value="/all/capitals", method=RequestMethod.GET)
	public ResponseEntity<List<City>> findAllCapitals() throws FileNotFoundException {

		File arquivo = new File("dados.csv");

		Scanner leitor = new Scanner(arquivo);
		List<City> cities = new ArrayList<>();

		leitor.nextLine();

		while(leitor.hasNext()) {

			String[] fields = leitor.nextLine().split(",");
			City city = new City(Integer.parseInt(fields[0]), fields[1], fields[2], Boolean.parseBoolean(fields[3]), Double.parseDouble(fields[4]), Double.parseDouble(fields[5]), fields[6], fields[7], fields[8], fields[9]);

			if (city.getCapital()) 
				cities.add(city);


		}
		leitor.close();


		List<City> sortedCities = cities.stream()
				.sorted(Comparator.comparing(City::getNo_accents))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(sortedCities);
	}

	/* 3 */
	@RequestMapping(value="/minMax", method=RequestMethod.GET)
	public ResponseEntity<List<StateDTO>> findMinMaxState() throws FileNotFoundException {

		File arquivo = new File("dados.csv");

		Scanner leitor = new Scanner(arquivo);
		List<City> cities = new ArrayList<>();

		leitor.nextLine();

		while(leitor.hasNext()) {

			String[] fields = leitor.nextLine().split(",");
			City city = new City(Integer.parseInt(fields[0]), fields[1], fields[2], Boolean.parseBoolean(fields[3]), Double.parseDouble(fields[4]), Double.parseDouble(fields[5]), fields[6], fields[7], fields[8], fields[9]);

			cities.add(city);


		}
		leitor.close();

		State rondonia = new State("RO", "Rondonia", cities.stream().filter(c -> c.getUf().equals("RO")).collect(Collectors.toList()));
		State acre = new State("AC", "Acre", cities.stream().filter(c -> c.getUf().equals("AC")).collect(Collectors.toList()));
		State amazonas = new State("AM", "Amazonas", cities.stream().filter(c -> c.getUf().equals("AM")).collect(Collectors.toList()));
		State roraima = new State("RR", "Roraima", cities.stream().filter(c -> c.getUf().equals("RR")).collect(Collectors.toList()));
		State para = new State("PA", "Para", cities.stream().filter(c -> c.getUf().equals("PA")).collect(Collectors.toList()));
		State amapa = new State("AP", "Amapa", cities.stream().filter(c -> c.getUf().equals("AP")).collect(Collectors.toList()));
		State tocantins = new State("TO", "Tocantins", cities.stream().filter(c -> c.getUf().equals("TO")).collect(Collectors.toList()));
		State maranhao = new State("MA", "Maranhao", cities.stream().filter(c -> c.getUf().equals("MA")).collect(Collectors.toList()));
		State piaui = new State("PI", "Piaui", cities.stream().filter(c -> c.getUf().equals("PI")).collect(Collectors.toList()));
		State ceara = new State("CE", "Ceara", cities.stream().filter(c -> c.getUf().equals("CE")).collect(Collectors.toList()));
		State rn = new State("RN", "Rio Grande do Norte", cities.stream().filter(c -> c.getUf().equals("RN")).collect(Collectors.toList()));
		State paraiba = new State("PB", "Paraiba", cities.stream().filter(c -> c.getUf().equals("PB")).collect(Collectors.toList()));
		State pernambuco = new State("PE", "Pernambuco", cities.stream().filter(c -> c.getUf().equals("PE")).collect(Collectors.toList()));
		State alagoas = new State("AL", "Alagoas", cities.stream().filter(c -> c.getUf().equals("AL")).collect(Collectors.toList()));
		State sergipe = new State("SE", "Sergipe", cities.stream().filter(c -> c.getUf().equals("SE")).collect(Collectors.toList()));
		State bahia = new State("BA", "Bahia", cities.stream().filter(c -> c.getUf().equals("BA")).collect(Collectors.toList()));
		State minas = new State("MG", "Minas Gerais", cities.stream().filter(c -> c.getUf().equals("MG")).collect(Collectors.toList()));
		State es = new State("ES", "Espírito Santo", cities.stream().filter(c -> c.getUf().equals("ES")).collect(Collectors.toList()));
		State rio = new State("RJ", "Rio de Janeiro", cities.stream().filter(c -> c.getUf().equals("RJ")).collect(Collectors.toList()));
		State sp = new State("SP", "São Paulo", cities.stream().filter(c -> c.getUf().equals("SP")).collect(Collectors.toList()));
		State parana = new State("PR", "Paraná", cities.stream().filter(c -> c.getUf().equals("PR")).collect(Collectors.toList()));
		State sc = new State("SC", "Santa Catarina", cities.stream().filter(c -> c.getUf().equals("SC")).collect(Collectors.toList()));
		State rs = new State("RS", "Rio Grande do Sul", cities.stream().filter(c -> c.getUf().equals("RS")).collect(Collectors.toList()));
		State ms = new State("MS", "Mato Grosso do Sul", cities.stream().filter(c -> c.getUf().equals("MS")).collect(Collectors.toList()));
		State mt = new State("MT", "Mato Grosso", cities.stream().filter(c -> c.getUf().equals("MT")).collect(Collectors.toList()));
		State goias = new State("GO", "Goiás", cities.stream().filter(c -> c.getUf().equals("GO")).collect(Collectors.toList()));
		State df = new State("DF", "Distrito Federal", cities.stream().filter(c -> c.getUf().equals("DF")).collect(Collectors.toList()));


		List<State> states = Arrays.asList(rondonia, acre, amazonas, roraima, para, amapa, tocantins, 
				maranhao, piaui, ceara, rn, paraiba, pernambuco, alagoas, sergipe, bahia, minas, es, rio ,sp,
				parana, sc, rs, ms, mt, goias, df);

		State maxState = Collections.max(states, Comparator.comparing(s -> s.getCityQuantity()));
		State minState = Collections.min(states, Comparator.comparing(s -> s.getCityQuantity()));

		List<StateDTO> minMaxStates = Arrays.asList(new StateDTO(maxState), new StateDTO(minState));

		return ResponseEntity.ok().body(minMaxStates);
	}



	/* 4 */
	@RequestMapping(value="/quantityByCity", method=RequestMethod.GET)
	public ResponseEntity<List<StateDTO>> findStateQuantityByCity() throws FileNotFoundException {

		File arquivo = new File("dados.csv");

		Scanner leitor = new Scanner(arquivo);
		List<City> cities = new ArrayList<>();

		leitor.nextLine();

		while(leitor.hasNext()) {

			String[] fields = leitor.nextLine().split(",");
			City city = new City(Integer.parseInt(fields[0]), fields[1], fields[2], Boolean.parseBoolean(fields[3]), Double.parseDouble(fields[4]), Double.parseDouble(fields[5]), fields[6], fields[7], fields[8], fields[9]);

			cities.add(city);


		}
		
		leitor.close();

		State rondonia = new State("RO", "Rondonia", cities.stream().filter(c -> c.getUf().equals("RO")).collect(Collectors.toList()));
		State acre = new State("AC", "Acre", cities.stream().filter(c -> c.getUf().equals("AC")).collect(Collectors.toList()));
		State amazonas = new State("AM", "Amazonas", cities.stream().filter(c -> c.getUf().equals("AM")).collect(Collectors.toList()));
		State roraima = new State("RR", "Roraima", cities.stream().filter(c -> c.getUf().equals("RR")).collect(Collectors.toList()));
		State para = new State("PA", "Para", cities.stream().filter(c -> c.getUf().equals("PA")).collect(Collectors.toList()));
		State amapa = new State("AP", "Amapa", cities.stream().filter(c -> c.getUf().equals("AP")).collect(Collectors.toList()));
		State tocantins = new State("TO", "Tocantins", cities.stream().filter(c -> c.getUf().equals("TO")).collect(Collectors.toList()));
		State maranhao = new State("MA", "Maranhao", cities.stream().filter(c -> c.getUf().equals("MA")).collect(Collectors.toList()));
		State piaui = new State("PI", "Piaui", cities.stream().filter(c -> c.getUf().equals("PI")).collect(Collectors.toList()));
		State ceara = new State("CE", "Ceara", cities.stream().filter(c -> c.getUf().equals("CE")).collect(Collectors.toList()));
		State rn = new State("RN", "Rio Grande do Norte", cities.stream().filter(c -> c.getUf().equals("RN")).collect(Collectors.toList()));
		State paraiba = new State("PB", "Paraiba", cities.stream().filter(c -> c.getUf().equals("PB")).collect(Collectors.toList()));
		State pernambuco = new State("PE", "Pernambuco", cities.stream().filter(c -> c.getUf().equals("PE")).collect(Collectors.toList()));
		State alagoas = new State("AL", "Alagoas", cities.stream().filter(c -> c.getUf().equals("AL")).collect(Collectors.toList()));
		State sergipe = new State("SE", "Sergipe", cities.stream().filter(c -> c.getUf().equals("SE")).collect(Collectors.toList()));
		State bahia = new State("BA", "Bahia", cities.stream().filter(c -> c.getUf().equals("BA")).collect(Collectors.toList()));
		State minas = new State("MG", "Minas Gerais", cities.stream().filter(c -> c.getUf().equals("MG")).collect(Collectors.toList()));
		State es = new State("ES", "Espírito Santo", cities.stream().filter(c -> c.getUf().equals("ES")).collect(Collectors.toList()));
		State rio = new State("RJ", "Rio de Janeiro", cities.stream().filter(c -> c.getUf().equals("RJ")).collect(Collectors.toList()));
		State sp = new State("SP", "São Paulo", cities.stream().filter(c -> c.getUf().equals("SP")).collect(Collectors.toList()));
		State parana = new State("PR", "Paraná", cities.stream().filter(c -> c.getUf().equals("PR")).collect(Collectors.toList()));
		State sc = new State("SC", "Santa Catarina", cities.stream().filter(c -> c.getUf().equals("SC")).collect(Collectors.toList()));
		State rs = new State("RS", "Rio Grande do Sul", cities.stream().filter(c -> c.getUf().equals("RS")).collect(Collectors.toList()));
		State ms = new State("MS", "Mato Grosso do Sul", cities.stream().filter(c -> c.getUf().equals("MS")).collect(Collectors.toList()));
		State mt = new State("MT", "Mato Grosso", cities.stream().filter(c -> c.getUf().equals("MT")).collect(Collectors.toList()));
		State goias = new State("GO", "Goiás", cities.stream().filter(c -> c.getUf().equals("GO")).collect(Collectors.toList()));
		State df = new State("DF", "Distrito Federal", cities.stream().filter(c -> c.getUf().equals("DF")).collect(Collectors.toList()));


		List<StateDTO> states = Arrays.asList(new StateDTO(rondonia), new StateDTO(acre), new StateDTO(amazonas), new StateDTO(roraima), new StateDTO(para), new StateDTO(amapa), new StateDTO(tocantins), 
				new StateDTO(maranhao), new StateDTO(piaui), new StateDTO(ceara), new StateDTO(rn), new StateDTO(paraiba), new StateDTO(pernambuco), new StateDTO(alagoas), new StateDTO(sergipe), new StateDTO(bahia), new StateDTO(minas), new StateDTO(es), new StateDTO(rio), new StateDTO(sp), new StateDTO(rondonia),
				new StateDTO(parana), new StateDTO(sc), new StateDTO(rs), new StateDTO(ms), new StateDTO(mt), new StateDTO(goias), new StateDTO(df));

		return ResponseEntity.ok().body(states);
	}
	
	
	/* 5 */
	@RequestMapping(value="/ibge/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<City> > findById(@PathVariable int id) throws FileNotFoundException {

		File arquivo = new File("dados.csv");

		Scanner leitor = new Scanner(arquivo);
		List<City> cities = new ArrayList<>();

		leitor.nextLine();

		while(leitor.hasNext()) {

			String[] campos = leitor.nextLine().split(",");
			City cidade = new City(Integer.parseInt(campos[0]), campos[1], campos[2], Boolean.parseBoolean(campos[3]), Double.parseDouble(campos[4]), Double.parseDouble(campos[5]), campos[6], campos[7], campos[8], campos[9]);

			cities.add(cidade);


		}
		leitor.close();


		List<City> cityByIbge = cities.stream()
				.filter(city -> city.getIbge_id() == id)
				.collect(Collectors.toList());

		if (cityByIbge.size() == 0) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}

		return ResponseEntity.ok().body(cityByIbge);
	}

	/* 6 */
	@RequestMapping(value="/uf/{uf}", method=RequestMethod.GET)
	public ResponseEntity<List<City>> findCitiesByUf(@PathVariable String uf) throws FileNotFoundException {

		File arquivo = new File("dados.csv");

		Scanner leitor = new Scanner(arquivo);
		List<City> cities = new ArrayList<>();

		leitor.nextLine();

		while(leitor.hasNext()) {

			String[] fields = leitor.nextLine().split(",");
			City city = new City(Integer.parseInt(fields[0]), fields[1], fields[2], Boolean.parseBoolean(fields[3]), Double.parseDouble(fields[4]), Double.parseDouble(fields[5]), fields[6], fields[7], fields[8], fields[9]);

			cities.add(city);


		}
		leitor.close();

		List<City> cityByUf = cities.stream()
				.filter(city -> city.getUf().equals(uf))
				.collect(Collectors.toList());

		if (cityByUf.size() == 0) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}

		return ResponseEntity.ok().body(cityByUf);
	}

	/* 7 */
	@PostMapping
	public ResponseEntity<City> addCity(@RequestBody City city) throws IOException {

		File file = new File("dados.csv");

		Scanner leitor = new Scanner(file);

		while(leitor.hasNext()) {
			leitor.nextLine();

		}

		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);

		pw.println(city.getIbge_id() + "," + city.getUf() + "," + city.getName() + "," + city.getCapital() + "," + city.getLon() + "," + city.getLat() + "," + city.getNo_accents() + "," + city.getAlternative_names() + "," + city.getMicroregion() + "," + city.getMesoregion());
		pw.flush();
		pw.close();
		leitor.close();

		// TODO mudar o path aqui em baixo (acho q ta certo)
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/ibge/{id}").buildAndExpand(city.getIbge_id()).toUri();
		return ResponseEntity.created(uri).build();
	}

	/* 8 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<City> delete(@PathVariable String id) throws IOException {

		File oldFile = new File("dados.csv");
		File newFile = new File("temp.csv");

		Scanner sc = new Scanner(oldFile);
		FileWriter fw = new FileWriter(newFile, true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);

		while(sc.hasNext()) {

			String[] fields = sc.nextLine().split(",");

			if (!fields[0].equals(id))
				pw.println(fields[0] + "," + fields[1] + "," + fields[2] + "," + fields[3] + "," + fields[4] + "," + fields[5]+ "," + fields[6]+ "," + fields[7] + "," + fields[8]+ "," + fields[9]);
		}

		pw.flush();
		pw.close();
		sc.close();

		oldFile.delete();
		File dump = new File("dados.csv");
		newFile.renameTo(dump);

		return ResponseEntity.noContent().build();
	}

	/* method for 9 ex */ 
	public int findIndexColumn(String[] columns, String column) {

		for (int i= 0; i < columns.length; i++) {
			if (columns[i].equals(column))
				return i;

		}
		return 0;
	}

	/* 9 */
	@RequestMapping(value="/{pColumn}/{filter}",method=RequestMethod.GET)
	public ResponseEntity<List<City>> findByColumnFiltered(@PathVariable String pColumn, @PathVariable String filter) throws IOException {

		File file = new File("dados.csv");

		Scanner sc = new Scanner(file);

		List<City> cities = new ArrayList<>();

		String[] columns = sc.nextLine().split(",");

		int indexColumn = findIndexColumn(columns, pColumn);

		while(sc.hasNext()) {

			String[] fields = sc.nextLine().split(",");
			City city = new City(Integer.parseInt(fields[0]), fields[1], fields[2], Boolean.parseBoolean(fields[3]), Double.parseDouble(fields[4]), Double.parseDouble(fields[5]), fields[6], fields[7], fields[8], fields[9]);

			if (fields[indexColumn].equals(filter) ) 
				cities.add(city);

		}

		sc.close();

		return ResponseEntity.ok().body(cities);
	}

	/* 10 */
	@RequestMapping(value="/registers/{pColumn}",method=RequestMethod.GET)
	public ResponseEntity<Integer> countUniqueRegistersByColumn(@PathVariable String pColumn) throws IOException {

		File file = new File("dados.csv");

		Scanner sc = new Scanner(file);

		HashSet<String> registers = new HashSet<>();

		String[] columns = sc.nextLine().split(",");

		int indexColumn = findIndexColumn(columns, pColumn);

		while(sc.hasNext()) {

			String[] fields = sc.nextLine().split(",");

			registers.add(fields[indexColumn]);

		}

		sc.close();

		return ResponseEntity.ok().body(registers.size());
	}


	/* 11 */
	@RequestMapping(value="/registers",method=RequestMethod.GET)
	public ResponseEntity<Integer> countRegisters() throws IOException {

		File file = new File("dados.csv");

		Scanner sc = new Scanner(file);

		int counter = 0;

		sc.nextLine();

		while(sc.hasNext()) {

			sc.nextLine();

			counter++;
		}

		sc.close();

		return ResponseEntity.ok().body(counter);
	}


}