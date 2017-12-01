//
//  HomeTableViewCell.swift
//  Food Friends
//
//  Created by mac on 12/1/17.
//  Copyright © 2017 HiepHo. All rights reserved.
//

import UIKit

class HomeTableViewCell: UITableViewCell {

    @IBOutlet var mainView: UIView!
    @IBOutlet var btnView: UIView!
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
        setupView()
    }
    
    func setupView(){
        mainView.layer.shadowColor = UIColor(red: 0/255.0, green: 0/255.0, blue: 0/255.0, alpha: 0.08).cgColor
        mainView.layer.shadowOpacity = 1
        mainView.layer.shadowOffset = CGSize.zero
        mainView.layer.shadowRadius = 4
        mainView.layer.cornerRadius = 10
        
        
        btnView.layer.shadowColor = UIColor(red: 0/255.0, green: 0/255.0, blue: 0/255.0, alpha: 0.08).cgColor
        btnView.layer.shadowOpacity = 1
        btnView.layer.shadowOffset = CGSize.zero
        btnView.layer.shadowRadius = 4
     //   btnView.layer.cornerRadius = 10
        
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
