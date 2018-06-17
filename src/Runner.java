
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Runner {

	
	public static void main(String[] args) {
		DispositivoInteligente d1 = new DispositivoInteligente();
		d1.setFabricante(new FabricanteY());
		
		DispositivoInteligente d2 = new DispositivoInteligente();
		d2.setFabricante(new FabricanteX());
		
		
        final RuntimeTypeAdapterFactory<Fabricante> typeFactory = RuntimeTypeAdapterFactory
                .of(Fabricante.class, "type")
                .registerSubtype(FabricanteX.class)
                .registerSubtype(FabricanteY.class);

        final Gson gson = new GsonBuilder().registerTypeAdapterFactory(
                typeFactory).create();
        
        List<DispositivoInteligente> dispositivos = 
        		Arrays.asList(d1, d2);
        
        
        String json = gson.toJson(dispositivos);
        System.out.println(json);
        
        final TypeToken<List<DispositivoInteligente>> dispositivoListType 
        	= new TypeToken<List<DispositivoInteligente>>() {};
        List<DispositivoInteligente> parseado = gson.fromJson(json, dispositivoListType.getType());
        
        for (DispositivoInteligente dispositivoInteligente : parseado) {
			System.out.println(dispositivoInteligente.getFabricante().getClass());
		}
		
	}
}
