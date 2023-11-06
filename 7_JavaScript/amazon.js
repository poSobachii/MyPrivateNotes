const {S3Client, ListBucketsCommand, S3, ListObjectsV2Command, ListObjectsCommand, CreateBucketCommand, PutObjectCommand, CopyObjectCommand} = require("@aws-sdk/client-s3");



var getS3Client = (objectStorageName, credentials) => {

    var apiUrlValue = 'https://ds11s3.com/';

    if (apiUrlValue) {
        // Create a new S3 SDK client instance.
        return new S3Client({
            region: 'us-east-1',
            endpoint: apiUrlValue,
            s3ForcePathStyle: true,
            credentials: {
                accessKeyId: '-7d46',
                secretAccessKey: '+eIfX13h5EEJ/xb'
            }
        });
    }
    return null;
}
client = getS3Client('', '');

async function listBucket() {
    const input = {
        "Bucket": "example-bucket",
        "MaxKeys": "100"
    }
    const command = new ListObjectsCommand(input);
    const response = await client.send(command);
    console.log(response)
}


async function createBucket() {
    const input = {
        "Bucket": "example-bucket2"
    };
    const command = new CreateBucketCommand(input);
    const response = await client.send(command);
    console.log(response);
}

async function copyFile() {
    const fs = require('fs');
    const filePath = 'test.json'
    const fileContent = fs.readFileSync(filePath);
    const bucketName = 'example-bucket';

    const input = {
        "Body": fileContent,
        "Bucket": bucketName,
        "Key": "exampleName/"
    };
    const command = new PutObjectCommand(input);
    const response = await client.send(command);
    console.log(response);
}


// listBucket();
createBucket();
// copyFile();


async function uploadFile(bucketName, filePath, key) {
    const fileContent = fs.readFileSync(filePath);
    try {
        const input = {
            "Body": fileContent,
            "Bucket": bucketName,
            "Key": key
        };
        const command = new PutObjectCommand(input);
        await client.send(command);
    } catch (err) {
        console.error(`Error uploading ${filePath} to ${bucketName}/${key}:`, err);
    }
}

async function scanAndUpload(dir, bucketName) {
    const files = fs.readdirSync(dir);
    for (const file of files) {
        const filePath = path.join(dir, file);
        const isDirectory = fs.lstatSync(filePath).isDirectory();

        if (isDirectory) {
            await scanAndUpload(filePath, bucketName);
        } else {
            const relativePath = path.relative(mainWorkingDirectory + '/' + bucketName, filePath);
            const key = relativePath;
            await uploadFile(bucketName, filePath, key);
        }
    }
}

async function createBucket(bucketName) {
    const input = {
        "Bucket": bucketName
    };
    const command = new CreateBucketCommand(input);
    await client.send(command);
}

async function uploadToS3() {
    for (const bucketName of bucketsEquivalentFolders) {
        const rootDir = path.join(mainWorkingDirectory, bucketName);
        try {
            await createBucket(bucketName);
            await scanAndUpload(rootDir, bucketName);
        } catch (err) {
            console.error(`Error creating bucket ${bucbucketFolderketName}:`, err);
        }
    }
}

uploadToS3();







// ===================================================================================================================================================================================================================================================================================================================================






// const fs = require('fs');
// const bucketName = 'examplebucket';
// const filePath = 'test.json';
// const fileContent = fs.readFileSync(filePath);
//
// const uploadParams = {
//     Bucket: bucketName,
//     Key: 'file.json',
//     Body: fileContent,
// };
//
//
// void s3.uploadPart(uploadParams, function (err, data) {
//     if (err) {
//         console.error('Error uploading file:', err);
//     } else {
//         console.log('File uploaded successfully:', data.Location);
//     }
// });

// var mys3 = () => {
//     return new S3({
//         region: 'us-east-1',
//         endpoint: 'https://ds11s3.com/',
//         // endpoint: 'https://.ds11s3ns.com/',
//         credentials: {
//             accessKeyId: '-7d46',
//             secretAccessKey: '+eIfX13h5EEJ/xb'
//         }
//     })
// }
// var s3 = mys3();


// client.send(command, (err, data) => {
//     if (err) {
//         console.error('Error listing buckets:', err);
//     } else {
//         console.log(data)
//         const bucketNames = data.Buckets.map(bucket => bucket.Name);
//
//         bucketNames.forEach(bucketName => {
//             console.log(`Bucket: ${bucketName}`);
//             const listObjectsCommand = new ListObjectsCommand({Bucket: bucketName, MaxKeys: 5,});
//
//             client.send(listObjectsCommand, (err, data) => {
//                 if (err) {
//                     console.error(`Error listing objects in bucket ${bucketName}:`, err);
//                 } else {
//                     const objectKeys = data.Contents.map(object => object.Key);
//                     console.log(`Objects in bucket ${bucketName}:`, objectKeys);
//                 }
//             });
//         });
//     }
// });
