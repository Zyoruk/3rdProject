import static org.junit.Assert.*;

import org.junit.Test;

import projectstructures.Domain;
import projectstructures.Region;


public class DomainAndRegionTester {

	@Test
	public void test() {
		
		Domain<String> myDomain = new Domain<String>();
		
		Region<String> region1 = new Region(myDomain);
		region1.setElement(region1.getID());		
		myDomain.addNode(region1);
		
		Region<String> region2 = new Region(myDomain);
		region1.setElement(region2.getID());		
		myDomain.addNode(region2);
		
		Region<String> region3 = new Region(myDomain);
		region1.setElement(region3.getID());		
		myDomain.addNode(region3);
		
		Region<String> region4 = new Region(myDomain);
		region1.setElement(region4.getID());		
		myDomain.addNode(region4);
		
		Region<String> region5 = new Region(myDomain);
		region1.setElement(region5.getID());		
		myDomain.addNode(region5);
		
		Region<String> region6 = new Region(myDomain);
		region1.setElement(region6.getID());		
		myDomain.addNode(region6);
		
		Region<String> region7 = new Region(myDomain);
		region1.setElement(region7.getID());		
		myDomain.addNode(region7);
		
		System.out.println(myDomain.describe());
		System.out.println(myDomain.getOrder());
		System.out.println(myDomain.getCurrentPoints());
		System.out.println(myDomain.getBountyHunterList().describe());

	}
	
}
