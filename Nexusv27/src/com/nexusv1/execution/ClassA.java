package com.nexusv1.execution;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.nexusv1.define.Defination;

public class ClassA {

	protected static void a() {

		Object localObject1 = new Defination();

		Object localObject2 = System.getProperty("user.dir");

		localObject1 = new File(localObject2 + "/"
				+ ((Defination) localObject1).a());

		localObject2 = new JSONObject();

		((JSONObject) localObject2).put("projectKey", "");
		((JSONObject) localObject2).put("reportDirectory", "");
		/*
		 * ((JSONObject) localObject2).put("userId", ""); ((JSONObject)
		 * localObject2).put("password", "");
		 */

		try {

			((File) localObject1).createNewFile();

		} catch (IOException localIOException1) {

			System.out.println("[" + ClassB.date()
					+ "] : File is not generated");

		}

		Object localObject3;

		try {

			localObject3 = new FileWriter(
					((File) localObject1).getAbsoluteFile());

			localObject3 = new BufferedWriter((Writer) localObject3);

			((BufferedWriter) localObject3).write(((JSONObject) localObject2)
					.toJSONString());

			((BufferedWriter) localObject3).close();

		} catch (IOException localIOException2) {

			localIOException2.printStackTrace();

		}
		System.out.println("[" + ClassB.date()
				+ "] : Configuration File is generated at "
				+ ((File) localObject1).getAbsolutePath());

		System.out.println("[" + ClassB.date() + "] : Please add the data");
	}

	protected static boolean b() {
		Object localObject1 = new Defination();

		Object localObject2 = System.getProperty("user.dir");

		boolean bool = true;

		localObject1 = new File(localObject2 + "/"
				+ ((Defination) localObject1).a());

		if (((File) localObject1).exists()) {
			localObject2 = new JSONParser();

			try {

				localObject1 = ((JSONObject) ((JSONParser) localObject2)
						.parse(new FileReader((File) localObject1)));

				if (((JSONObject) localObject1).get("projectKey").toString()
						.equals("")
						| ((JSONObject) localObject1).get("projectKey")
								.toString().equals(null)
						| ((JSONObject) localObject1).get("reportDirectory")
								.toString().equals("")
						| ((JSONObject) localObject1).get("projectKey")
								.toString().equals(null)) {

					System.out.println("[" + ClassB.date()
							+ "] : Please Enter details In Configuration File");
					System.out
							.println("["
									+ ClassB.date()
									+ "] : Project Key and Report directory are required");

					bool = false;
				}

				if ((((JSONObject) localObject1).get("reportDirectory").equals(
						"") | ((JSONObject) localObject1)
						.get("reportDirectory").toString().equals(null))) {
					return false;
				}

				try {

					localObject1 = ((JSONObject) localObject1)
							.get("reportDirectory").toString()
							.replace(File.separator, "/");

					/*System.err.println(localObject1.toString().replace(
							File.separator, "/"));*/

					localObject1 = (new File((String) localObject1))
							.listFiles();

					File[] localObject3 = (File[]) localObject1;

					//System.err.println(localObject3.toString());

					int num = localObject3.length;
					int i = 0;

					for (int l = 0; l < num; l++) {
						/*System.err.println(((File) (localObject3[l])).getName()
								+ "name");*/
						if (((File) (localObject3[l])).getName().equals(
								"testng-results.xml")) {

							i = 1;
							System.err.println("-------------------");
							break;
						}
					}

					if (i != 0) {
						return bool;
					}
					bool = false;
					System.out
							.println("["
									+ ClassB.date()
									+ "] : Please Give Valid Testng Report Directory Path with this format eg .C:/bot/test-output");

				} catch (Exception ex) {
					bool = false;
					System.out
							.println("["
									+ ClassB.date()
									+ "] : Please Give Valid Testng Report Directory Path with this format eg .C:/bot/test-output");

				}
				
				bool = false;

			} catch (Exception ex) {

				// ex.printStackTrace();

			}
		} else {
			bool = false;
			System.out
					.println("["
							+ ClassB.date()
							+ "] : Please genereate settings file by -init command, Before run the bot");

		}

		//System.err.println("boo" + bool);
		return bool;
	}

	protected static String[] c() {
		Object localObject1 = new Defination();

		HashMap localHashMap = new HashMap();

		String[] array = new String[5];

		Object localObject2 = System.getProperty("user.dir");
		if (((File) (localObject1 = new File(localObject2 + "/"
				+ ((Defination) localObject1).a()))).exists()) {
			localObject2 = new JSONParser();
			try {
				localObject1 = (JSONObject) (localObject1 = ((JSONParser) localObject2)
						.parse(new FileReader((File) localObject1)));
				localHashMap.put("projectKey",
						((JSONObject) localObject1).get("projectKey")
								.toString());
				localHashMap.put("reportDirectory", ((JSONObject) localObject1)
						.get("reportDirectory").toString());
			} catch (Exception localException) {
				(localException).printStackTrace();
			}

			array[0] = "projectKey";
			array[1] = (String) ((HashMap) localObject1).get("projectKey")
					.toString();

			array[2] = "reportDirectory";
			array[3] = (String) ((HashMap) localObject1).get("reportDirectory")
					.toString();

			//System.err.println(array);

		}
		return array;
	}
}
