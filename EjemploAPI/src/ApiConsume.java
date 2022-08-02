import java.net.HttpURLConnection; //Connection
import java.net.URL; //Manejodepaginaswebs
import java.util.Scanner; //Ni te lo tengo que explicar.
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ApiConsume 
{
	public static void main (String [] args)
	{
		try
		{
			URL url = new URL ("https://api.open-meteo.com/v1/forecast?latitude=43.25&longitude=3.59&hourly=temperature_2m"); //URL de la api	
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			int tiempoRespuesta = conn.getResponseCode();

			if (tiempoRespuesta != 200)//200 es el tiempo de espera para que funcione.
									   //Si es distinto de 200 (401) arroja error
									   // ya que la conección no se realizo
			{		
				throw new RuntimeException("HttpResponseCode " + tiempoRespuesta);
			}
			else
			{
				StringBuilder tiempoMiengo = new StringBuilder();
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext())
				{
					tiempoMiengo.append(sc.nextLine());
				}
				sc.close();
				String ficheroSalida = "tiempoMiengo_JSON.txt";
				BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroSalida));
				bw.write(tiempoMiengo.toString());
				bw.close();
				System.out.println("Escritura realizada correctamente!");
			}
	}
	catch (Exception e)
	{
		System.err.println("Error!!");
		System.exit(1);
	}
}
}

