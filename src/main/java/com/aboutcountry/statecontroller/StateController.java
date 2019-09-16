package com.aboutcountry.statecontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aboutcountry.statemodel.Dist;
import com.aboutcountry.statemodel.State;
import com.aboutcountry.statemodel.Taluka;
import com.aboutcountry.stateservice.DistService;
import com.aboutcountry.stateservice.DistServiceAll;
import com.aboutcountry.stateservice.StateService;
import com.aboutcountry.stateservice.TalukaService;
import com.aboutcountry.stateservice.TalukaServiceAll;

@RestController
@ComponentScan(basePackages="com.aboutcountry.statecontroller")
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private DistService distService;
	
	@Autowired
	private DistServiceAll distServiceAll;
	
	@Autowired
	private TalukaService talukaService;
	
	@Autowired
	private TalukaServiceAll talukaServiceAll;
	
	
	
	@RequestMapping("/states")
	public ResponseEntity<List<State>> listAllStates() 
	{
	      
	 return new ResponseEntity<List<State>> (stateService.getState(), HttpStatus.OK);
		
	}
	
	
	
	@RequestMapping("/dists")
	public List<Dist> DistList()
	{
		return distServiceAll.getListOfDisk();
	}
	
	
	
	@RequestMapping("/dists/{sid}")
	public List<Dist> DistListbyid(@PathVariable(name="sid")String sid)
	{
		return distService.getDist(sid); 
		
	}
	
	
	@RequestMapping("/talukas")
	public List<Taluka> TalukaList()
	{
		return talukaServiceAll.getListOfTaluka();
	}
	
	@RequestMapping("/talukas/{did}")
	public List<Taluka> TalukaListByid(String did)
	{
		return talukaService.getTaluka(did);
	}
	
	 

}
