package module.ontology;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.FileManager;
import module.Module;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.StringReader;

public class OntologyModule implements Module {

	public static String NTRIPLE = "N-TRIPLE";

	private Model model = null;

	public OntologyModule() {
		boot();
	}

	@Override
	public void boot() {
		model = ModelFactory.createDefaultModel();
		initialise();
	}

	@Override
	public void initialise() {

	}

	public void setupOntologyWithFile(String filename, String type) throws FileNotFoundException {
		InputStream in = FileManager.get().open(filename);
		if (null == in) {
			throw new FileNotFoundException(filename + " not found");
		}
		model.read(in, null, type);
	}

	public void setupOntologyWithString(String text, String type) {
		model.read(new StringReader(text), null, type);
	}

	public Model getModel() {
		return model;
	}

	public StmtIterator getStatements(Resource subject, String predicate, RDFNode object) throws NullPointerException {
		if (null == model) {
			throw new NullPointerException("Please setup the ontology model first.");
		}
		Selector selector = new SimpleSelector(subject, model.createProperty(predicate), object);
		StmtIterator si = model.listStatements(selector);
		return si;
	}
}
