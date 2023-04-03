public class xmlreader {
	public static By bylocator;

	public static void BuildLocator (String objectName) throws Exception
	{
		File inputFile = new File("/Users/varsha/Downloads/Hello-World-JAVA-master/DemoSampleApp_selenium/NewFile.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("Element");
     	for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\nCurrent Element :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;

			
				System.out.println("NameOfElement  : " 
						+ eElement
						.getElementsByTagName("NameOfElement")
						.item(0)
						.getTextContent());
				System.out.println("Type : " 
						+ eElement
						.getElementsByTagName("Type")
						.item(0)
						.getTextContent());
				System.out.println("Value: " 
						+ eElement
						.getElementsByTagName("Value")
						.item(0)
						.getTextContent());

			}
		}				
	}