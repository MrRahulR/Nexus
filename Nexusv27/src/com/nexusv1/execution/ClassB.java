package com.nexusv1.execution;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.beust.jcommander.JCommander;
import com.nexusv1.define.Defination;
import com.sun.management.OperatingSystemMXBean;

public class ClassB {

	public static void a(String[] paramArrayOfString) {
		try {
			new ClassA();
			Object localObject = new Arguments();
			ClassB localb = new ClassB();

			JCommander localJCommander;

			(localJCommander = new JCommander(localObject))
					.parse(paramArrayOfString);

			if (((Arguments) localObject).a()) {
				ClassA.a();
				return;
			}
			if (!(ClassA.b()))
				return;

			paramArrayOfString = ClassA.c();

			System.out
					.println("---------------------------------------------------");

			HashMap<String, String> paramMapofStrings = new HashMap<String, String>();

			System.out.println(paramArrayOfString[1] + "111"
					+ paramArrayOfString[3]);

			paramMapofStrings.put(paramArrayOfString[0], paramArrayOfString[1]);
			paramMapofStrings.put(paramArrayOfString[2], paramArrayOfString[3]);

			localObject = a(paramMapofStrings);
			System.out.println(paramArrayOfString[3] + "---"
					+ paramArrayOfString[1]);
			try {
				if (!(((String) ((Map) localObject).get("flag")).equals("true")))
					return;
				System.out.println("[" + date()
						+ "] : Auuthentication successfull");
				System.out
						.println("---------------------------------------------------");
				System.out
						.println("---------------------------------------------------");
				System.out.println("[" + date()
						+ "] : NexusBot is launched sucessfully...");

				String dir = paramArrayOfString[3];
				String uid = paramArrayOfString[1];

				localb.b(dir, uid);

				return;
			} catch (Exception localException1) {
				return;
			}
		} catch (Exception localException2) {
			(localException2).printStackTrace();
		}
	}

	protected static String date() {
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(
				"dd-MM-yyyy HH:mm:ss");
		Calendar localCalendar = Calendar.getInstance();
		return localSimpleDateFormat.format(localCalendar.getTime());
	}

	private static Map a(Map paramMap) {

		System.err.println(paramMap.values().toString() + " ++");

		Object obj1 = new Defination();

		HashMap hMap = new HashMap();

		System.out.println("[" + date()
				+ "] : Wait.. Nexus is trying to identify you");
		try {

			Thread.sleep(1000L);

		} catch (InterruptedException localInterruptedException1) {

		}

		Object obj2;

		HttpClient httpClient = new DefaultHttpClient();

		((HashMap) (obj2 = new JSONObject())).put("projectKey",
				paramMap.get("projectKey"));

		System.err.println(obj2.toString() + "obj");

		HttpPost requestCall = new HttpPost(Defination.a);

		/*
		 * System.err.println(requestCall.toString()); obj1 = null;
		 * 
		 * try { obj1 = new StringEntity(obj2.toString());
		 * 
		 * System.err.println("OBJ!" + obj1); } catch (Exception e) {
		 * e.printStackTrace(); }
		 * 
		 * ((StringEntity)
		 * obj1).setContentType("application/json;charset=UTF-8");
		 * ((StringEntity) obj1).setContentEncoding(new BasicHeader(
		 * "Content-Type", "application/json;charset=UTF-8"));
		 * 
		 * requestCall.addHeader("Accept", "application/json");
		 * 
		 * System.err.println(obj1 + "enttit");
		 * 
		 * requestCall.setEntity((HttpEntity) obj1);
		 * 
		 * System.err.println(obj1 + "====" + requestCall);
		 * 
		 * obj1 = HttpClientBuilder.create().build();
		 * 
		 * System.err.println(obj1.toString() + "====212" + requestCall);
		 */

		try {

			/*System.err.println("------------"+httpClient.execute(requestCall).toString()
					+ "------------");*/

			String obj = obj2.toString();

			StringEntity entity = new StringEntity(obj);

			entity.setContentType("application/json");
			requestCall.addHeader("content-type", "application/json");
			requestCall.addHeader("Accept", "application/json");

			requestCall.setEntity(entity);

			System.err.println("entity-----"
					+ requestCall.getHeaders("content-type").toString());

			obj2 = httpClient.execute(requestCall);

			Object responseHandler = new BasicResponseHandler()
					.handleResponse((HttpResponse) obj2);

			if ((paramMap = (JSONObject) (responseHandler = ((JSONParser) (obj1 = new JSONParser()))
					.parse((String) responseHandler))).get("flag").toString()
					.equals("true")) {

				hMap.put("flag", paramMap.get("flag").toString());

			} else {

				System.out.println("[" + date() + "] : "
						+ paramMap.get("message"));
			}

		} catch (Exception localException) {

			localException.printStackTrace();
			System.out.println("[" + date()
					+ "] : Opps...It seems like some Network problem ");
		}
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException localInterruptedException2) {
			(localInterruptedException2).printStackTrace();
		}

		return hMap;
	}

	private void b(String paramString1, String paramString2) {

		for (;;) {
			if (a(paramString1)) {

				System.err.println("SUCCESSSSSSSSSSSSSSSSSss");

				Object obj1 = a(paramString1, paramString2);
				Defination def = new Defination();

				try {
					Thread.sleep(1000L);
				} catch (InterruptedException localInterruptedException1) {
					localInterruptedException1.printStackTrace();
				}

				Object obj2 = new HttpPost(def.a);

				Object obj3 = null;

				try {

					obj3 = new StringEntity(((JSONObject) obj1).toString());

				} catch (Exception e) {
					e.printStackTrace();
				}

				((StringEntity) obj3)
						.setContentType("application/json;charset=UTF-8");
				((StringEntity) obj3).setContentEncoding(new BasicHeader(
						"Content-Type", "application/json;charset=UTF-8"));
				((HttpPost) obj2).setHeader("Accept", "application/json");
				((HttpPost) obj2).setEntity((HttpEntity) obj3);
				obj1 = HttpClientBuilder.create().build();

				try {
					obj1 = ((HttpClient) obj1).execute((HttpUriRequest) obj2);
					Object obj4 = new BasicResponseHandler()
							.handleResponse((HttpResponse) obj1);
					obj2 = new JSONParser();
					obj3 = null;

					try {
						obj3 = ((JSONParser) obj2).parse((String) obj4);
					} catch (ParseException localParseException) {
						localParseException.printStackTrace();
					}

					obj4 = null;
					obj4 = obj3;

					if (((JSONObject) obj4).get("flag").toString()
							.equals("false")) {
						obj4 = ((JSONObject) obj4).get("data");
						System.out.println("[" + date() + "] : Build-"
								+ ((JSONObject) obj4).get("sequence")
								+ " reached successfully On VigoWorld.");
						System.out.println("[" + date()
								+ "] : You can view this build on - " + def.a
								+ "/app/builds/"
								+ ((JSONObject) obj4).get("id"));
						System.out
								.println("---------------------------------------------------");
						System.out.println("[" + date()
								+ "] : You can play with automation again.");
						System.out
								.println("---------------------------------------------------");
					} else {
						System.out
								.println("["
										+ date()
										+ "] : "
										+ ((JSONObject) obj4).get("message")
												.toString());
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					Thread.sleep(1000L);
				} catch (InterruptedException localInterruptedException2) {
					localInterruptedException2.printStackTrace();
				}
			} else {
				b(paramString1, paramString2);
			}
			paramString1 = paramString1;
		}
	}

	private static boolean a(String paramString) {

		boolean bool = false;
		Path path;

		path = Paths.get(paramString, new String[0]);

		try {

			Object obj1 = path.getFileSystem().newWatchService();

			System.err.println(obj1.toString());

			path.register((WatchService) obj1, new WatchEvent.Kind[] {
					StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY });

			WatchKey key = null;

			try {
				key = ((WatchService) obj1).take();
			} catch (Exception e) {

			}

			for (WatchEvent event : key.pollEvents()) {

				WatchEvent.Kind kind = event.kind();

				WatchEvent<Path> ev = (WatchEvent<Path>) event;
				Path fileName = ev.context();

				System.err.println(kind.name() + ":" + fileName);

				if (kind == ENTRY_MODIFY
						&& fileName.toString().equals("testng-results.xml")) {
					System.err.println("Source file checked");
				}

				bool = key.reset();
				if (!bool) {
					System.err.println(bool);
					break;
				}

			}
		} catch (Exception e) {

		}
		return bool;
	}

	private static JSONObject a(String paramString1, String paramString2) {

		File file;

		file = new File(paramString1 + "/testng-results.xml");

		JSONObject localJSONObject1 = null;

		new ClassB();

		b();

		DocumentBuilderFactory localObject1;

		try {
			Thread.sleep(1000L);
		} catch (InterruptedException localInterruptedException1) {
			(localInterruptedException1).printStackTrace();
		}
		DocumentBuilder localObject2;
		Document localObject3;

		try {

			localObject1 = DocumentBuilderFactory.newInstance();

			localObject2 = localObject1.newDocumentBuilder();

			(localObject3 = localObject2.parse(file)).getDocumentElement()
					.normalize();

			localJSONObject1 = new JSONObject();

			Node node = (localObject3.getElementsByTagName("testng-results"))
					.item(0);
			Element em = (Element) node;

			localJSONObject1.put("projectKey", paramString2);
			localJSONObject1.put("skip", Integer.valueOf(Integer
					.parseInt(((Element) em).getAttribute("skipped"))));
			localJSONObject1.put("fail", Integer.valueOf(Integer
					.parseInt(((Element) em).getAttribute("failed"))));
			localJSONObject1.put("total", Integer.valueOf(Integer
					.parseInt(((Element) em).getAttribute("total"))));
			localJSONObject1.put("pass", Integer.valueOf(Integer
					.parseInt(((Element) em).getAttribute("passed"))));

			System.err.println("jsonobb-------------------- " + node);
			System.err.println(localJSONObject1.toJSONString().toString());

			JSONObject obj4 = new JSONObject();
			Object obj5 = ManagementFactory.getRuntimeMXBean();

			long l = ((OperatingSystemMXBean) ManagementFactory
					.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
			Object obj6 = ((RuntimeMXBean) obj5).getSystemProperties();

			obj4.put("name", ((Map) obj6).get("os.name"));
			obj4.put("ram", Math.round(l / 1024.0D / 1024.0D / 1024.0D) + "GB");
			obj4.put("arc", (String) ((Map) obj6).get("sun.arch.data.model")
					+ " bit");
			obj4.put("version", ((Map) obj6).get("os.version"));
			obj4.put("hostname ", ((Map) obj6).get("user.name"));

			localJSONObject1.put("os", obj4);
			localJSONObject1.put("sdk", b());

			int i = (TimeZone.getDefault()).getRawOffset() / 60000;

			System.out.println(i);

			localJSONObject1.put("tz", Integer.valueOf(i));
			NodeList obj7 = localObject3.getElementsByTagName("suite");

			System.err
					.println("--------------------------------------------------------");
			System.err.println(localJSONObject1.toJSONString().toString());
			System.err.println(obj4.toString());
			System.err.println(l + " " + obj5.toString());
			System.err.println(i + "   " + obj7);
			System.err
					.println("--------------------------------------------------------");

			Object obj8 = new JSONArray();

			for (i = 0; i < obj7.getLength(); i++) {

				Object objx1 = obj7.item(i);
				Object objx2 = (Element) objx1;

				JSONObject locJsonObject2 = new JSONObject();

				locJsonObject2.put("name",
						((Element) objx2).getAttribute("name"));
				locJsonObject2.put("duration",
						Integer.valueOf(Integer.parseInt(((Element) objx2)
								.getAttribute("duration-ms"))));
				locJsonObject2.put("start",
						((Element) objx2).getAttribute("started-at"));
				locJsonObject2.put("finish",
						((Element) objx2).getAttribute("finished-at"));

				objx2 = null;

				System.err
						.println("--------------------------------------------------------");
				System.err.println(locJsonObject2.toJSONString().toString());

				new JSONArray();

				JSONArray jsonArray = new JSONArray();

				if (((Node) objx1).hasChildNodes()) {

					NodeList locNodeList = ((Node) objx1).getChildNodes();
					for (int j = 0; j < locNodeList.getLength(); j++) {

						Object objx3, objx4, objx5, objx6, objx7, objx8, objx9;

						if (((Node) (objx3 = locNodeList.item(j)))
								.getNodeName().equals("groups")) {

							objx2 = new JSONArray();

							objx4 = ((Node) objx3).getChildNodes();
							for (int k = 0; k < ((NodeList) objx4).getLength(); k++) {

								objx1 = new JSONArray();

								objx5 = ((NodeList) objx4).item(k);

								try {
									objx6 = new JSONArray();
									if (((Node) objx5).hasChildNodes()) {

										Element lElement = (Element) objx5;

										((JSONObject) objx1).put("name",
												lElement.getAttribute("name"));

										objx7 = ((Node) objx5).getChildNodes();

										for (int n = 0; n < ((NodeList) objx7)
												.getLength(); n++) {

											Node lNode;

											if ((lNode = ((NodeList) objx7)
													.item(n)).getNodeName()
													.equals("method")) {

												objx8 = (Element) lNode;
												objx9 = new JSONObject();
												((JSONObject) objx9)
														.put("name",
																((Element) objx8)
																		.getAttribute("name"));
												((JSONObject) objx9)
														.put("class",
																((Element) objx8)
																		.getAttribute("class"));

												((JSONArray) objx6).add(objx9);

												System.out.println(objx1
														.toString()
														+ "\n"
														+ objx2.toString()
														+ "\n"
														+ objx3.toString()
														+ "\n"
														+ objx4.toString()
														+ "\n"
														+ objx5.toString()
														+ "\n"
														+ objx6.toString()
														+ "\n"
														+ objx7.toString()
														+ "\n"
														+ objx8.toString()
														+ "\n"
														+ objx9.toString()
														+ "\n");

											}

										}
										((JSONObject) objx1).put("methods",
												objx6);
										((JSONArray) objx2).add(objx1);

									}
								} catch (Exception lc) {
									((Throwable) (objx6 = lc))
											.printStackTrace();

								}

							}
						}

						if ((((Node) objx3).getNodeType() == 1)
								&& (((Node) objx3).getNodeName().equals("test"))) {

							objx4 = (Element) objx3;

							JSONObject locJsonObject3 = new JSONObject();

							locJsonObject3.put("name",
									((Element) objx4).getAttribute("name"));
							locJsonObject3.put("duration", Integer
									.valueOf(Integer.parseInt(((Element) objx4)
											.getAttribute("duration-ms"))));
							locJsonObject3.put("start", ((Element) objx4)
									.getAttribute("started-at"));
							locJsonObject3.put("finish", ((Element) objx4)
									.getAttribute("finished-at"));

							objx5 = new JSONArray();

							if (((Node) objx3).hasChildNodes()) {

								objx6 = ((Node) objx3).getChildNodes();
								for (int m = 0; m < ((NodeList) objx6)
										.getLength(); m++) {

									if (((NodeList) objx6).item(m)
											.hasChildNodes()) {
										objx7 = ((NodeList) objx6).item(m);

										NodeList lNode2 = ((Node) objx7)
												.getChildNodes();

										for (int q = 0; q < lNode2.getLength(); q++) {

											objx8 = lNode2.item(q);

											if ((((Node) objx8).getNodeType() == 1)
													&& (((Node) objx8)
															.getNodeName()
															.equals("test-method"))) {

												objx9 = (Element) objx8;

												objx1 = new JSONArray();

												if (!((Element) objx9)
														.getAttribute(
																"is-config")
														.equals("true")) {

													objx3 = new JSONObject();

													if (((Element) objx9)
															.getAttribute(
																	"status")
															.equals("PASS")) {
														((JSONObject) objx3)
																.put("status",
																		Integer.valueOf(Integer
																				.parseInt("1")));
													}
													if (((Element) objx9)
															.getAttribute(
																	"status")
															.equals("FAIL")) {
														((JSONObject) objx3)
																.put("status",
																		Integer.valueOf(Integer
																				.parseInt("2")));
													}
													if (((Element) objx9)
															.getAttribute(
																	"status")
															.equals("SKIP")) {
														((JSONObject) objx3)
																.put("status",
																		Integer.valueOf(Integer
																				.parseInt("3")));
													}

													((JSONObject) objx3)
															.put("name",
																	((Element) objx9)
																			.getAttribute("name"));
													((JSONObject) objx3)
															.put("duration",
																	Integer.valueOf(Integer
																			.parseInt(((Element) objx9)
																					.getAttribute("duration-ms"))));
													((JSONObject) objx3)
															.put("start",
																	time(((Element) objx9)
																			.getAttribute("started-at")));
													((JSONObject) objx3)
															.put("finish",
																	time(((Element) objx9)
																			.getAttribute("finished-at")));
													objx4 = new JSONObject();

													if (((Node) objx8)
															.hasChildNodes()) {
														objx7 = ((Node) objx8)
																.getChildNodes();

														for (int i2 = 0; i2 < ((NodeList) objx7)
																.getLength(); i2++) {
															NodeList lNodeList3;
															Node lNode3;
															objx9 = ((NodeList) objx7)
																	.item(i2);
															if ((((Node) objx9)
																	.getNodeName()
																	.equals("exception"))
																	&& (((Node) objx9)
																			.hasChildNodes())) {
																lNodeList3 = ((Node) objx9)
																		.getChildNodes();
																for (int x = 0; x < lNodeList3
																		.getLength(); x++) {
																	if ((lNode3 = lNodeList3
																			.item(x))
																			.getNodeName()
																			.equals("message")) {
																		((JSONObject) objx4)
																				.put("message",
																						lNode3.getTextContent());
																	}
																	if (lNode3
																			.getNodeName()
																			.equals("full-stacktrace")) {
																		((JSONObject) objx4)
																				.put("stacktrace",
																						lNode3.getTextContent());
																	}
																}
															}

															if ((((Node) objx9)
																	.getNodeName()
																	.equals("reporter-output"))
																	&& ((Node) objx9)
																			.hasChildNodes()) {
																lNodeList3 = ((Node) objx9)
																		.getChildNodes();
																for (int z = 0; z < lNodeList3
																		.getLength(); z++) {
																	lNode3 = lNodeList3
																			.item(z);
																	if (lNode3
																			.getNodeName()
																			.equals("line")) {
																		((JSONArray) objx1)
																				.add(lNode3
																						.getTextContent());
																	}

																}
															}
														}

													}
													((JSONObject) objx3).put(
															"exception", objx4);
													((JSONObject) objx3).put(
															"steps", objx1);
													((JSONArray) objx5)
															.add(objx3);

												}
											}
										}

									}

								}

								locJsonObject3.put("methods", objx5);

							}

							jsonArray.add(locJsonObject3);
						}

					}

				}
				locJsonObject2.put("groups", objx2);
				locJsonObject2.put("tests", jsonArray);
				((JSONArray) obj8).add(locJsonObject2);

			}
			localJSONObject1.put("modules", obj8);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("[" + date()
				+ "] : We're connecting you...Stay there!");
		System.err.println(localJSONObject1.toJSONString().toString());

		return localJSONObject1;

	}

	private static JSONObject b() {
		JSONObject localJSONObject = new JSONObject();
		Object localObject = ((RuntimeMXBean) (localObject = ManagementFactory
				.getRuntimeMXBean())).getSystemProperties();
		localJSONObject.put("name", "Java");
		localJSONObject.put("arc",
				(String) ((Map) localObject).get("sun.arch.data.model")
						+ " bit");
		localJSONObject.put("version", ((Map) localObject).get("java.version"));
		return localJSONObject;
	}

	private static String time(String paramString) {
		SimpleDateFormat localSimpleDateFormat;
		(localSimpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss'Z'")).setTimeZone(TimeZone.getDefault());
		Date localDate = null;
		try {
			localDate = localSimpleDateFormat.parse(paramString);
		} catch (Exception localException) {
		}
		localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		return localSimpleDateFormat.format(localDate);
	}
}
