//
//  DesMessTableViewCell.swift
//  Food Friends
//
//  Created by mac on 12/2/17.
//  Copyright © 2017 HiepHo. All rights reserved.
//

import UIKit

class DesMessTableViewCell: UITableViewCell {

    @IBOutlet var view: UIView!
    @IBOutlet var label: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        self.view.layer.cornerRadius = 15.0
        self.view.layer.masksToBounds = true
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
