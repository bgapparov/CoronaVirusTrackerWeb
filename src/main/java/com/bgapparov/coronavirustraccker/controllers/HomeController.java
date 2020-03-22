package com.bgapparov.coronavirustraccker.controllers;

import com.bgapparov.coronavirustraccker.models.LocationStats;
import com.bgapparov.coronavirustraccker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    private String home(Model model){

        List<LocationStats> allStats = coronaVirusDataService.getAllstats();
        int totalReportCases = allStats.stream().mapToInt(stat->stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat->stat.getDiffFromPrevDay()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportCases", totalReportCases);
        model.addAttribute("totalNewCases", totalNewCases);

        return "home";
    }

}
