package com.Anshul.myjournal.Controllers;

import com.Anshul.myjournal.Entities.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JournalController {


    private Map<Long,  JournalEntry> journalentries = new HashMap<>();
    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalentries.values());
    }


    @GetMapping("/id/{myid}")
    public JournalEntry getByid(@PathVariable Long myid){
        return journalentries.get(myid);
    }

    @DeleteMapping("/id/{myid}")
    public JournalEntry deleteByid(@PathVariable Long myid){
        return journalentries.remove(myid);
    }
      @PutMapping("/id/{myid}")
    public JournalEntry updateJournal(@PathVariable Long myid,@RequestBody JournalEntry journalEntry){
        return journalentries.put(myid,journalEntry);
    }


@PostMapping
    public boolean createEntry(@RequestBody JournalEntry journalEntry){

        return true;
    }

}
