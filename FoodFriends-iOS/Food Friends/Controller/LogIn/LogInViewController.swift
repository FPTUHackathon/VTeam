//
//  LogInViewController.swift
//  Food Friends
//
//  Created by mac on 12/1/17.
//  Copyright © 2017 HiepHo. All rights reserved.
//

import UIKit
import SkyFloatingLabelTextField
import Firebase


class LogInViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet var btnLogin: UIButton!
    @IBOutlet var btnReg: UIButton!
    @IBOutlet var lblpassword: SkyFloatingLabelTextField!
    @IBOutlet var lblemail: SkyFloatingLabelTextField!
    override func viewDidLoad() {
        super.viewDidLoad()

        setupNib()
        setupView()
        setupTextField()
        // Do any additional setup after loading the view.
    }
    
    func setupTextField(){
        lblemail.delegate = self
        lblpassword.delegate = self
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        
        super.touchesBegan(touches, with:event)
        self.view.endEditing(true)
    }
    
    func setupNib(){
        let nib = UINib(nibName: "LogInViewController", bundle:nil)
        let myVC = nib.instantiate(withOwner: self, options: nil).first as? LogInViewController
    }

    func setupView(){
        let lightGreyColor = UIColor(red: 197/255, green: 205/255, blue: 205/255, alpha: 1.0)
        let darkGreyColor = UIColor(red: 52/255, green: 42/255, blue: 61/255, alpha: 1.0)
        let overcastBlueColor = UIColor(red: 0, green: 187/255, blue: 204/255, alpha: 1.0)
        
        lblemail.placeholder = "Nhập Email"
        lblemail.title = "Email của bạn"
        lblpassword.placeholder = "Nhập mật khẩu"
        lblpassword.title = "Mật khẩu của bạn"
        
        lblemail.tintColor = overcastBlueColor // the color of the blinking cursor
        lblemail.textColor = darkGreyColor
        lblemail.lineColor = lightGreyColor
        lblemail.selectedTitleColor = overcastBlueColor
        lblemail.selectedLineColor = overcastBlueColor
        lblemail.lineHeight = 1.0 // bottom line height in points
        lblemail.selectedLineHeight = 2.0
        
        
        lblpassword.tintColor = overcastBlueColor // the color of the blinking cursor
        lblpassword.textColor = darkGreyColor
        lblpassword.lineColor = lightGreyColor
        lblpassword.selectedTitleColor = overcastBlueColor
        lblpassword.selectedLineColor = overcastBlueColor
        lblpassword.lineHeight = 1.0 // bottom line height in points
        lblpassword.selectedLineHeight = 2.0
        
        btnLogin.layer.cornerRadius = 20
        btnReg.layer.cornerRadius = 20
        
    }
    
    
   
    @IBAction func invokeLogin(_ sender: Any) {
        if let email = self.lblemail.text, let password = self.lblpassword.text {
//            showSpinner {
                // [START headless_email_auth]
                Auth.auth().signIn(withEmail: email, password: password) { (user, error) in
                    // [START_EXCLUDE]
                    //self.hideSpinner {
                        if let error = error {
                           // self.showMessagePrompt(error.localizedDescription)
                            print(error)
                            let alert = UIAlertController(title: "Sai mật khẩu/email", message: "Mật khẩu/email bạn đã nhập không chính xác. Vui lòng thử lại.", preferredStyle: UIAlertControllerStyle.alert)
                            alert.addAction(UIAlertAction(title: "OK", style: UIAlertActionStyle.default, handler: nil))
                            self.present(alert, animated: true, completion: nil)
                            return
                        }
                        self.dismiss(animated: true, completion: nil)
                        let vc = MainViewController(nibName: "MainViewController", bundle: nil)
                        self.present(vc, animated: true, completion: nil)
                        //self.navigationController!.popViewController(animated: true)
                   // }
                    // [END_EXCLUDE]
                }
                // [END headless_email_auth]
            }
//        } else {
//            self.showMessagePrompt("email/password can't be empty")
//        }
    }
    
    @IBAction func invokeReg(_ sender: Any) {
    }
}
