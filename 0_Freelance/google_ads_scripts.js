function main() {
    var dateRange = 'LAST_30_DAYS'; // specify the time period
    var labelName = 'NEW';
    var lowImpressionsThreshold = 20;
    var emailAddress1 = 'nulll@hotmail.com';
    var emailAddress2 = 'test@test.com';

    var keywordsToPause = [];
    var keywordsToRemove = [];
    var keywordsWithBetterImpressions = [];

    var adGroups = AdsApp.adGroups().forDateRange(dateRange).get();

    while (adGroups.hasNext()) {
        var adGroup = adGroups.next();
        if (!adGroup.labels().withCondition('Name = "' + labelName + '"').get().hasNext()) {
            var keywords = adGroup.keywords().get();
            while (keywords.hasNext()) {
                var keyword = keywords.next();
                if (keyword.getImpressions() < lowImpressionsThreshold) {
                    keywordsToPause.push(keyword.getText());
                } else {
                    keywordsWithBetterImpressions.push(keyword.getText());
                }
            }
            adGroup.pauseKeywords(keywordsToPause);
            keywordsToRemove = keywordsToRemove.concat(keywordsToPause);
            keywordsToPause = [];
        }
    }
    adGroups.removeKeywords(keywordsToRemove);

    var sheet = SpreadsheetApp.create('Keywords With No Impressions');
    var keywordsPausedSheet = sheet.getActiveSheet();
    keywordsPausedSheet.appendRow(['Keywords Paused/Removed']);
    for (var i = 0; i < keywordsToRemove.length; i++) {
        keywordsPausedSheet.appendRow([keywordsToRemove[i]]);
    }

    var keywordsImpressionsSheet = sheet.insertSheet();
    keywordsImpressionsSheet.appendRow(['Keywords With Better Impressions']);
    for (var i = 0; i < keywordsWithBetterImpressions.length; i++) {
        keywordsImpressionsSheet.appendRow([keywordsWithBetterImpressions[i]]);
    }

    var emailBody = 'Number of keywords paused/removed: ' + keywordsToRemove.length + '\n' +
        'Keywords: ' + keywordsToRemove + '\n' +
        'Time: ' + new Date() + '\n' +
        'Ad group: ' + adGroup.getName() + '\n' +
        'Keywords with better impressions: ' + keywordsWithBetterImpressions;

    GmailApp.sendEmail(emailAddress1, 'Keywords With No Impressions', emailBody);
    GmailApp.sendEmail(emailAddress2, 'Keywords With No Impressions', emailBody);
}

//  ==============================================================================================================================

// Define the date range for the script
var dateRange = "LAST_30_DAYS";

// Define the email addresses to send notifications
var emailAddresses = ["nulll@hotmail.com", "test@test.com"];

// Define the label to exclude new campaigns
var excludeLabel = "NEW";

// Define the threshold for low impressions
var lowImpressionsThreshold = 20;

// Define the Google Sheet to keep record of keywords that are removed or paused
var sheet = SpreadsheetApp.create("Keywords Removed or Paused");
var sheetTab = sheet.getSheetByName("Sheet1");

// Get all keywords from the Google Ads account
var keywords = AdsApp.keywords().withCondition("Impressions < " + lowImpressionsThreshold)
    .forDateRange(dateRange)
    .get();

// Keep track of keywords that are removed or paused
var keywordsRemoved = [];
var keywordsPaused = [];

// Keep track of keywords with better impressions
var keywordsWithBetterImpressions = [];

// Loop through all keywords
while (keywords.hasNext()) {
    var keyword = keywords.next();
    var adGroup = keyword.getAdGroup();

    // Check if the ad group has the exclude label
    if (!adGroup.labels().withCondition("Name = '" + excludeLabel + "'").get().hasNext()) {
        // Check if the keyword has impressions
        if (keyword.getImpressions() < lowImpressionsThreshold) {
            // Pause the keyword
            keyword.pause();
            keywordsPaused.push(keyword.getText());
        } else {
            // Add keyword to the list of keywords with better impressions
            keywordsWithBetterImpressions.push(keyword.getText());
        }
    }
}

// Write the keywords that were removed or paused to the Google Sheet
sheetTab.getRange(1, 1, keywordsRemoved.length, 1).setValues(keywordsRemoved);
sheetTab.getRange(1, 2, keywordsPaused.length, 1).setValues(keywordsPaused);

// Write the keywords with better impressions to another tab in the Google Sheet
var sheetTab2 = sheet.getSheetByName("Sheet2");
sheetTab2.getRange(1, 1, keywordsWithBetterImpressions.length, 1).setValues(keywordsWithBetterImpressions);

// Send a notification email with the details
var emailBody = "Number of keywords: " + (keywordsRemoved.length + keywordsPaused.length) + "\n\n";
emailBody += "Keywords removed: " + keywordsRemoved.join(", ") + "\n\n";
emailBody += "Keywords paused: " + keywordsPaused.join(", ") + "\n\n";
emailBody += "Keywords with better impressions: " + keywordsWithBetterImpressions.join(", ") + "\n\n";
emailBody += "Time: " + new Date().toString();

for (var i = 0; i < emailAddresses.length; i++) {
    GmailApp.sendEmail(emailAddresses[i], "Keywords Removed or Paused", emailBody);
}

//  ==============================================================================================================================

function main() {
    var dateRange = AdsApp.currentAccount().getStatsFor("YESTERDAY");
    var emailAddresses = ["nulll@hotmail.com", "test@test.com"];

    var campaigns = AdsApp.campaigns().get();
    while (campaigns.hasNext()) {
        var campaign = campaigns.next();
        if (campaign.labels().withCondition("Name = 'NEW'").get().hasNext()) {
            continue;
        }
        var adGroups = campaign.adGroups().get();
        while (adGroups.hasNext()) {
            var adGroup = adGroups.next();
            var ads = adGroup.ads().get();
            if (ads.totalNumEntities() > 1) {
                var lowestCTRAd;
                var lowestCTR = 100;
                while (ads.hasNext()) {
                    var ad = ads.next();
                    var adStats = ad.getStatsFor(dateRange);
                    if (adStats.getCtr() < lowestCTR) {
                        lowestCTR = adStats.getCtr();
                        lowestCTRAd = ad;
                    }
                }
                lowestCTRAd.pause();
                Logger.log("Paused ad with ID " + lowestCTRAd.getId() + " and CTR of " + lowestCTR + "%");
            }
        }
    }

    var emailBody = "The following ads were paused due to low CTR:\n\n";
    emailBody += Logger.getLog();
    GmailApp.sendEmail(emailAddresses.join(","), "Ads Paused Due to Low CTR", emailBody);
}

//  ==============================================================================================================================

//  ==============================================================================================================================
//  ==============================================================================================================================
//  ==============================================================================================================================
//  ==============================================================================================================================
//  ==============================================================================================================================
//  ==============================================================================================================================
//  ==============================================================================================================================
//  ==============================================================================================================================
//  ==============================================================================================================================
//  ==============================================================================================================================