//
//  ContentView.swift
//  LogIn
//
//  Created by Alexa on 12/02/22.
//

import SwiftUI




struct ContentView: View {
    
    @State var user: String = ""
    @State var pass: String = ""
    
    
    var body: some View {
        
        VStack{
        
            Image("tesla")
                .resizable()
                .aspectRatio( contentMode: .fill)
                .padding(.bottom, 150)
                .frame(width: 200, height: 200, alignment: .center)
                .offset(y: 30)
                

            
            
            //Usuario
            HStack{
                Image(systemName: "person.circle" )
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .padding()
                    .frame(width: 60, height: 60)
                    .foregroundColor(Color.red)
                    
                
                VStack{
                    TextField("Username", text: $user)
                    Divider()
                }
                
            }.padding(.horizontal, 50)
            
            
            //Contraseña
            HStack{
                Image(systemName: "lock.circle" )
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .foregroundColor(Color.red)
                    .padding()
                    .frame(width: 60, height: 60)
                    
                
                VStack{
                    SecureField("Password", text: $pass)
                    //TextField("Password", text: $pass)
                    Divider()
                }
                                
                
                
            }.padding(.horizontal, 50)
            
            HStack{
                
                
                /*
                NavigationLink {
                    Home()
                } label: {
                    Button("Sign In"){
                        
                        if pass == "123" && user == "Bb" {
                            print($user,$pass)
                            
                            Home()
                          
                            
                        }else{
                            Forgot()
                        }
                        
                     }
                     .buttonStyle(.bordered)
                     .buttonBorderShape(.capsule)
                     .foregroundColor(Color.red)
                     .padding(.all)
                    Divider()
                }*/

                
                
                 
                 
                 NavigationLink(destination: Home(),label: { Text("Sig In") })
                     .buttonStyle(.bordered)
                     .buttonBorderShape(.capsule)
                     .foregroundColor(Color.red)
                     .padding(.top)
                 
                 NavigationLink(destination: Home(),label: { Text("Forgot password?") })
                     .foregroundColor(Color.gray)
                     .padding(.top)
                  
                  
                 

                 
                 Button("Forgot password?"){
                     
                 }
                 .foregroundColor(Color.gray)
                 .padding(.all)
            }.frame(width: 300, height: 20, alignment: .center)
            
           
             
            
            
            
            
            //Text("Hello, \(user)!")
            
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
        Home()
    }
}
