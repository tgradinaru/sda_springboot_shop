import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WelcomeDataService } from '../service/data/welcome-data.service';



@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})


export class WelcomeComponent implements OnInit {

  name=''
  constructor(private route:ActivatedRoute,
    private service: WelcomeDataService
    ) { }

  ngOnInit() {
    //console.log(this.route.snapshot.params['name'])
    this.name=this.route.snapshot.params['name']
  }

  getWelcomeMessage()
{
  //console.log("welcome");
  this.service.executeHelloWorld().subscribe(
    response =>this.handleSuccessfulResponse(response.name),
      error=>this.handleErrorResponse(error)


    
        );
       console.log("hellolast");
      }
    
      handleSuccessfulResponse(response)
      {
    console.log(response);
      }

      handleErrorResponse(response)
      {
    console.log(response);
      }
}
