//
//  StartMessTableViewCell.swift
//  Food Friends
//
//  Created by mac on 12/2/17.
//  Copyright © 2017 HiepHo. All rights reserved.
//

import UIKit

class StartMessTableViewCell: UITableViewCell {

    @IBOutlet var view: UIView!
    @IBOutlet var label: UILabel!
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
        label.numberOfLines = 0
        self.view.layer.cornerRadius = 15.0 //self.view.frame.width / 2.0
        self.view.layer.masksToBounds = true
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
